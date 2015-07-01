package parser.textmodel.main;

import parser.textmodel.ast.ASTDeclarationSpecifiers;
import parser.textmodel.ast.ASTDeclarator;
import parser.textmodel.ast.ASTDirectDeclarator;
import parser.textmodel.ast.ASTEnumSpecifier;
import parser.textmodel.ast.ASTFlowModelDefinition;
import parser.textmodel.ast.ASTFunctionDeclarator;
import parser.textmodel.ast.ASTFunctionDirectDeclarator;
import parser.textmodel.ast.ASTFunctionModelDeclaration;
import parser.textmodel.ast.ASTFunctionModelDefinition;
import parser.textmodel.ast.ASTFunctionPointerDirectDeclarator;
import parser.textmodel.ast.ASTInitializer;
import parser.textmodel.ast.ASTMultiDeclarationSpecifiers;
import parser.textmodel.ast.ASTMultiTypeSpecifier;
import parser.textmodel.ast.ASTPointer;
import parser.textmodel.ast.ASTStructOrUnionSpecifier;
import parser.textmodel.ast.ASTTextModelDeclaration;
import parser.textmodel.ast.ASTTranslationUnit;
import parser.textmodel.ast.ASTTypeSpecifier;
import parser.textmodel.ast.ASTVariableDirectDeclarator;
import parser.textmodel.ast.ASTVariableModelDeclaration;
import parser.textmodel.ast.ASTcommentAnnoName;
import parser.textmodel.ast.ASTcommentAnnoParam;
import parser.textmodel.ast.Node;
import parser.textmodel.ast.ParseException;
import parser.textmodel.ast.SimpleNode;
import parser.textmodel.ast.TMParser;
import parser.textmodel.ast.TMParserConstants;
import parser.textmodel.ast.Token;

public class Main {

    /**
     * @param args
     */
    public static void main(String args[]) {
        args = new String[1];
        // args[0] = "C:\\tools\\kepler38\\workspace1111111\\JavaCC_3\\src\\example.c";
        args[0] = "C:\\tools\\kepler38\\workspace1111111\\AAA\\1\\1.func";
        // args[0] = "C:\\tools\\kepler38\\workspace1111111\\AAA\\1\\var01.c";

        TMParser parser;

        if (args.length == 0) {
            System.out.println("TextModel Parser:  Reading from standard input . . .");
            parser = new TMParser(System.in);
        } else if (args.length == 1) {
            System.out.println("TextModel Parser:  Reading from file " + args[0] + " . . .");
            try {
                parser = new TMParser(new java.io.FileInputStream(args[0]));
            } catch (java.io.FileNotFoundException e) {
                System.out.println("TextModel Parser:  File " + args[0] + " not found.");
                return;
            }
        } else {
            System.out.println("TextModel Parser:  Usage is one of:");
            System.out.println("        TMParser < inputfile");
            System.out.println("OR");
            System.out.println("        TMParser inputfile");
            return;
        }
        try {
            ASTTranslationUnit unit = parser.TranslationUnit();
            printModel(unit);
            System.out.println("TextModel Parser:  Parsed successfully.");
        } catch (ParseException e) {
            System.out.println("TextModel Parser:  Encountered errors during parse.");
            e.printStackTrace();
        }
    }

    private static final int MODEL_STATE_INDEX = 0;

    private static final int MODEL_NAME_INDEX = 1;

    private static final int MODEL_PARAM_INDEX = 2;

    private static final int MODEL_TYPE_INDEX = 3;

    private static final int MODEL_POINTER_INDEX = 4;

    private static final int MODEL_ARRAY_INDEX = 5;

    private static final int MODEL_IDENTIFIER_INDEX = 6;

    private static final int MODEL_DECLARATION_INDEX = 7;

    private static final int MODEL_INITIALIZER_INDEX = 8;

    private static final int MODEL_PARAMETER_INDEX = 9;

    private static void printModel(String[] model) {
        System.out.println("\t" + "モデル名称                          ：" + model[MODEL_NAME_INDEX] + "(" + model[MODEL_STATE_INDEX] + ")");
        System.out.println("\t" + "引数(Comment)      ：" + model[MODEL_PARAM_INDEX]);
        System.out.println("\t" + "引数(Declaration)  ：" + model[MODEL_PARAMETER_INDEX]);
        System.out.println("\t" + "タイプ                                  ：" + model[MODEL_TYPE_INDEX]);
        System.out.println("\t" + "ポインター                            ：" + model[MODEL_POINTER_INDEX]);
        System.out.println("\t" + "配列                                   ：" + model[MODEL_ARRAY_INDEX]);
        System.out.println("\t" + "名称                                   ：" + model[MODEL_IDENTIFIER_INDEX]);
        System.out.println("\t" + "宣言                                   ：" + model[MODEL_DECLARATION_INDEX]);
        System.out.println("\t" + "初期値                               ：" + model[MODEL_INITIALIZER_INDEX]);
        System.out.println("\t" + "----------------------------------");
    }

    public static void printModel(ASTTranslationUnit unit) {
        SimpleNode m, n;
        String[] model;

        for (int ord = 0; ord < unit.jjtGetNumChildren(); ord++) {
            m = (SimpleNode) unit.jjtGetChild(ord);
            if (m instanceof ASTTextModelDeclaration) {
                model = new String[10];
                n = (SimpleNode) m.jjtGetChild(0);
                model[MODEL_NAME_INDEX] = getModelName(n);
                if (n instanceof ASTVariableModelDeclaration) {
                    model[MODEL_STATE_INDEX] = "変数モデル";
                    model[MODEL_TYPE_INDEX] = getVariableModelType(n);
                    model[MODEL_POINTER_INDEX] = String.valueOf(isVariableModelPointer(n));
                    model[MODEL_ARRAY_INDEX] = String.valueOf(isVariableModelArray(n));
                    {
                        String[] pair = getVariableModelDeclaration(n);
                        if (pair.length == 2) {
                            model[MODEL_IDENTIFIER_INDEX] = pair[0];
                            model[MODEL_DECLARATION_INDEX] = pair[1];
                        }
                    }
                    model[MODEL_INITIALIZER_INDEX] = getVariableModelInitializer(n);
                } else if (n instanceof ASTFunctionModelDeclaration) {
                    model[MODEL_STATE_INDEX] = "関数モデル";
                    model[MODEL_PARAM_INDEX] = getModelParam(n);
                    model[MODEL_TYPE_INDEX] = getFunctionModelType(n);
                    model[MODEL_POINTER_INDEX] = String.valueOf(isFunctionModelPointer(n));
                    model[MODEL_ARRAY_INDEX] = String.valueOf(Boolean.FALSE);
                    {
                        String[] pair = getFunctionModelDeclaration(n);
                        if (pair.length == 2) {
                            model[MODEL_IDENTIFIER_INDEX] = pair[0];
                            model[MODEL_DECLARATION_INDEX] = pair[1];
                        }
                    }
                    model[MODEL_PARAMETER_INDEX] = getFunctionModelDeclarationParamList(n);
                } else if (n instanceof ASTFunctionModelDefinition) {
                    model[MODEL_STATE_INDEX] = "関数モデル";
                    model[MODEL_PARAM_INDEX] = getModelParam(n);
                    model[MODEL_TYPE_INDEX] = getFunctionModelType(n);
                    model[MODEL_POINTER_INDEX] = String.valueOf(isFunctionModelPointer(n));
                    model[MODEL_ARRAY_INDEX] = String.valueOf(Boolean.FALSE);
                    {
                        String[] pair = getFunctionModelDeclaration(n);
                        if (pair.length == 2) {
                            model[MODEL_IDENTIFIER_INDEX] = pair[0];
                            model[MODEL_DECLARATION_INDEX] = pair[1];
                        }
                    }
                    model[MODEL_PARAMETER_INDEX] = getFunctionModelDeclarationParamList(n);
                } else if (n instanceof ASTFlowModelDefinition) {
                    model[MODEL_STATE_INDEX] = "フローモデル";
                }
                printModel(model);
            }
        }
    }

    private static String getModelName(Node node) {
        SimpleNode m = (SimpleNode) node.jjtGetChild(0).jjtGetChild(0);
        if (m instanceof ASTcommentAnnoName) {
            return m.getLastToken().image == null ? null : m.getLastToken().image.trim();
        }
        return null;
    }

    /**************** 関数モデル ******************/

    private static String getModelParam(Node node) {
        SimpleNode m, n;
        StringBuffer result = new StringBuffer();

        m = (SimpleNode) node.jjtGetChild(0);
        for (int ord = 0; ord < m.jjtGetNumChildren(); ord++) {
            n = (SimpleNode) m.jjtGetChild(ord);
            if (n instanceof ASTcommentAnnoParam) {
                if (result.length() > 0) {
                    result.append(", " + n.getLastToken().image);
                } else {
                    result.append(n.getLastToken().image);
                }
            }
        }
        return result.length() > 0 ? result.toString().trim() : null;
    }

    private static String getFunctionModelType(Node node) {
        StringBuffer result = new StringBuffer();
        SimpleNode m = (SimpleNode) node.jjtGetChild(1);
        getDeclarationType(m, result);

        return result.toString();
    }

    private static boolean isFunctionModelPointer(Node node) {
        SimpleNode m;

        if (node.jjtGetNumChildren() > 2) {
            m = (SimpleNode) node.jjtGetChild(2).jjtGetChild(0);
            if (m instanceof ASTPointer) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    private static String[] getFunctionModelDeclaration(Node node) {
        SimpleNode m;

        if (node.jjtGetNumChildren() > 2 && (node.jjtGetChild(2) instanceof ASTFunctionDeclarator || node.jjtGetChild(2) instanceof ASTDeclarator)) {
            m = (SimpleNode) node.jjtGetChild(2);
        } else if (node.jjtGetNumChildren() > 1 && (node.jjtGetChild(1) instanceof ASTFunctionDeclarator || node.jjtGetChild(1) instanceof ASTDeclarator)) {
            m = (SimpleNode) node.jjtGetChild(1);
        } else {
            return new String[2];
        }

        if (m.jjtGetChild(0) instanceof ASTPointer) {
            return getFunctionDeclarationPlus(m.getFirstToken(), m.getLastToken(), 1, 0);
        } else {
            return getFunctionDeclarationPlus(m.getFirstToken(), m.getLastToken(), 0, -1);
        }
    }

    private static String[] getFunctionDeclarationPlus(Token first, Token last, int identifier, int skip) {
        Token next;
        int index = 0;
        boolean skippable = false;
        boolean isSeparators = true;
        String[] result = { null, null };
        StringBuffer decl = new StringBuffer();

        if (first != null && last != null) {
            next = first;
            while (true) {
                if (index == identifier) {
                    result[0] = next.image;
                    decl.append(next.image);
                } else if (index == skip) {
                    // skip *
                } else {
                    if (next.kind == TMParserConstants.LPAREN || next.kind == TMParserConstants.RPAREN || next.kind == TMParserConstants.LBRACKET
                            || next.kind == TMParserConstants.RBRACKET || next.kind == TMParserConstants.COMMA) {
                        if (decl.length() > 0 && decl.charAt(decl.length() - 1) == ' ') {
                            decl.deleteCharAt(decl.length() - 1);
                        }
                    } else if (next.kind == TMParserConstants.LBRACKET) {
                        if (decl.length() > 1 && (decl.charAt(decl.length() - 1) == ' ' && decl.charAt(decl.length() - 2) == ']')) {
                            decl.deleteCharAt(decl.length() - 1);
                        }
                    }

                    if (next.kind == TMParserConstants.RBRACKET) {
                        skippable = false;
                    }
                    if (skippable) {
                        // skippable
                    } else {
                        if (isSeparators) {
                            decl.append(next.image);
                            isSeparators = false;
                        } else if (next.kind == TMParserConstants.LPAREN || next.kind == TMParserConstants.RPAREN || next.kind == TMParserConstants.LBRACKET) {
                            decl.append(next.image);
                            isSeparators = true;
                        } else {
                            decl.append(next.image + " ");
                            isSeparators = false;
                        }
                    }
                    if (next.kind == TMParserConstants.LBRACKET) {
                        skippable = true;
                    }
                }
                if (next == last)
                    break;
                next = next.next;
                index++;
            }
        }
        result[1] = decl.length() > 0 ? decl.toString().trim() : null;
        return result;
    }

    private static String getFunctionModelDeclarationParamList(Node node) {
        SimpleNode m, n, o, p;
        StringBuffer result = new StringBuffer();

        if (node.jjtGetNumChildren() > 2 && (node.jjtGetChild(2) instanceof ASTFunctionDeclarator || node.jjtGetChild(2) instanceof ASTDeclarator)) {
            m = (SimpleNode) node.jjtGetChild(2);
        } else if (node.jjtGetNumChildren() > 1 && (node.jjtGetChild(1) instanceof ASTFunctionDeclarator || node.jjtGetChild(1) instanceof ASTDeclarator)) {
            m = (SimpleNode) node.jjtGetChild(1);
        } else {
            return null;
        }

        if (m.jjtGetNumChildren() > 1 && (m.jjtGetChild(1) instanceof ASTFunctionDirectDeclarator || m.jjtGetChild(1) instanceof ASTDirectDeclarator)) {
            n = (SimpleNode) m.jjtGetChild(1);
        } else if (m.jjtGetNumChildren() > 0 && (m.jjtGetChild(0) instanceof ASTFunctionDirectDeclarator || m.jjtGetChild(0) instanceof ASTDirectDeclarator)) {
            n = (SimpleNode) m.jjtGetChild(0);
        } else {
            return null;
        }

        String[] param;
        if (n.jjtGetNumChildren() > 0 && n.jjtGetChild(0).jjtGetNumChildren() > 0) {
            o = (SimpleNode) n.jjtGetChild(0).jjtGetChild(0);
            for (int ord = 0; ord < o.jjtGetNumChildren(); ord++) {
                param = new String[5];
                p = (SimpleNode) o.jjtGetChild(ord);
                // タイプ
                param[0] = getFunctionModelParamType(p.jjtGetChild(0));
                // ポインター
                param[1] = String.valueOf(isFunctionModelParamPointer(p));
                // 配列
                param[2] = String.valueOf(isFunctionModelParamArray(p));
                {
                    String[] pair = getFunctionModelParamDeclaration(p);
                    if (pair.length == 2) {
                        // 名称
                        param[3] = pair[0];
                        // 宣言文字列(名称を抜いた)
                        param[4] = pair[1];
                    }
                }

                if (result.length() > 0) {
                    result.append(", ");
                }
                result.append(param[3]);
                result.append("<");
                if (!param[0].isEmpty()) {
                    result.append(param[0]);
                    if (param[4] != null && !param[4].isEmpty()) {
                        result.append(" ");
                        result.append(param[4]);
                    }
                } else {
                    if (param[4] != null && !param[4].isEmpty()) {
                        result.append(param[4]);
                    }
                }
                result.append(">");
            }
            return result.toString().trim();
        }
        return null;
    }

    private static String getFunctionModelParamType(Node node) {
        StringBuffer result = new StringBuffer();
        getDeclarationType(node, result);
        return result.toString().trim();
    }

    private static boolean isFunctionModelParamPointer(Node node) {
        SimpleNode m;

        if (node.jjtGetNumChildren() > 1) {
            m = (SimpleNode) node.jjtGetChild(1).jjtGetChild(0);
            if (m instanceof ASTPointer) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    private static boolean isFunctionModelParamArray(Node node) {
        SimpleNode m, n, o;

        if (node.jjtGetNumChildren() > 1) {
            m = (SimpleNode) node.jjtGetChild(1);
            if (m.jjtGetNumChildren() > 1) {
                n = (SimpleNode) m.jjtGetChild(1);
            } else if (m.jjtGetNumChildren() > 0) {
                n = (SimpleNode) m.jjtGetChild(0);
            } else {
                return Boolean.FALSE;
            }

            if (n instanceof ASTVariableDirectDeclarator) {
                if (n.getLastToken().kind == TMParserConstants.RBRACKET) {
                    return Boolean.TRUE;
                }
            } else if (n instanceof ASTFunctionPointerDirectDeclarator) {
                if (n.jjtGetChild(0).jjtGetNumChildren() == 1) {
                    o = (SimpleNode) n.jjtGetChild(0).jjtGetChild(0);
                } else if (n.jjtGetChild(0).jjtGetNumChildren() > 1) {
                    o = (SimpleNode) n.jjtGetChild(0).jjtGetChild(1);
                } else {
                    return Boolean.FALSE;
                }
                if (o.getLastToken().kind == TMParserConstants.RBRACKET) {
                    return Boolean.TRUE;
                }
            }
        }
        return Boolean.FALSE;
    }

    private static String[] getFunctionModelParamDeclaration(Node node) {
        SimpleNode m, n;

        if (node.jjtGetNumChildren() > 1) {
            m = (SimpleNode) node.jjtGetChild(1);
            if (m.jjtGetNumChildren() > 1) {
                n = (SimpleNode) m.jjtGetChild(1);
            } else if (m.jjtGetNumChildren() > 0) {
                n = (SimpleNode) m.jjtGetChild(0);
            } else {
                return new String[2];
            }

            if (n instanceof ASTVariableDirectDeclarator) {
                if (((SimpleNode) n.getParent()).jjtGetChild(0) instanceof ASTPointer) {
                    return getParameterDeclarationPlus(((SimpleNode) n.getParent()).getFirstToken(), ((SimpleNode) n.getParent()).getLastToken(), 1);
                } else {
                    return getParameterDeclarationPlus(((SimpleNode) n.getParent()).getFirstToken(), ((SimpleNode) n.getParent()).getLastToken(), 0);
                }
            } else if (n instanceof ASTFunctionPointerDirectDeclarator) {
                if (n.jjtGetChild(0).jjtGetChild(0) instanceof ASTPointer) {
                    return getParameterDeclarationPlus(n.getFirstToken(), n.getLastToken(), 2);
                } else {
                    return getParameterDeclarationPlus(n.getFirstToken(), n.getLastToken(), 1);
                }
            }
        }
        return new String[2];
    }

    private static String[] getParameterDeclarationPlus(Token first, Token last, int skip) {
        Token next;
        int index = 0;
        boolean skippable = false;
        boolean isSeparators = true;
        String[] result = { null, null };
        StringBuffer decl = new StringBuffer();

        if (first != null && last != null) {
            next = first;
            while (true) {
                if (index == skip) {
                    result[0] = next.image;
                } else if (next.kind == TMParserConstants.IDENTIFIER) {
                    if (decl.length() > 0 && decl.charAt(decl.length() - 1) == ' ') {
                        decl.deleteCharAt(decl.length() - 1);
                    }
                } else {
                    if (next.kind == TMParserConstants.LPAREN || next.kind == TMParserConstants.RPAREN || next.kind == TMParserConstants.RBRACKET
                            || next.kind == TMParserConstants.COMMA) {
                        if (decl.length() > 0 && decl.charAt(decl.length() - 1) == ' ') {
                            decl.deleteCharAt(decl.length() - 1);
                        }
                    } else if (next.kind == TMParserConstants.LBRACKET) {
                        if (decl.length() > 1 && (decl.charAt(decl.length() - 1) == ' ' && decl.charAt(decl.length() - 2) == ']')) {
                            decl.deleteCharAt(decl.length() - 1);
                        }
                    }

                    if (next.kind == TMParserConstants.RBRACKET) {
                        skippable = false;
                    }
                    if (skippable) {
                        // skippable
                    } else {
                        if (isSeparators) {
                            decl.append(next.image);
                            isSeparators = false;
                        } else if (next.kind == TMParserConstants.LPAREN || next.kind == TMParserConstants.RPAREN || next.kind == TMParserConstants.LBRACKET) {
                            decl.append(next.image);
                            isSeparators = true;
                        } else {
                            decl.append(next.image + " ");
                            isSeparators = false;
                        }
                    }
                    if (next.kind == TMParserConstants.LBRACKET) {
                        skippable = true;
                    }
                }
                if (next == last)
                    break;
                next = next.next;
                index++;
            }
        }
        result[1] = decl.length() > 0 ? decl.toString().trim() : null;
        return result;
    }

    /**************** 変数モデル ******************/

    private static String getVariableModelType(Node node) {
        StringBuffer result = new StringBuffer();
        SimpleNode m = (SimpleNode) node.jjtGetChild(1);
        getDeclarationType(m, result);

        return result.toString().trim();
    }

    private static boolean isVariableModelPointer(Node node) {
        SimpleNode m, n;

        if (node.jjtGetNumChildren() > 2) {
            m = (SimpleNode) node.jjtGetChild(2).jjtGetChild(0).jjtGetChild(0).jjtGetChild(0);
            if (m instanceof ASTPointer) {
                return Boolean.TRUE;
            } else if (m instanceof ASTFunctionPointerDirectDeclarator) {
                n = (SimpleNode) m.jjtGetChild(0).jjtGetChild(0);
                if (n instanceof ASTPointer) {
                    return Boolean.TRUE;
                }
            }
        }
        return Boolean.FALSE;
    }

    private static boolean isVariableModelArray(Node node) {
        SimpleNode m, n, o;

        if (node.jjtGetNumChildren() > 2) {
            m = (SimpleNode) node.jjtGetChild(2).jjtGetChild(0).jjtGetChild(0);
            if (m.jjtGetNumChildren() == 1) {
                n = (SimpleNode) m.jjtGetChild(0);
            } else if (m.jjtGetNumChildren() > 1) {
                n = (SimpleNode) m.jjtGetChild(1);
            } else {
                return Boolean.FALSE;
            }

            if (n instanceof ASTVariableDirectDeclarator) {
                if (n.getLastToken().kind == TMParserConstants.RBRACKET) {
                    return Boolean.TRUE;
                }
            } else if (n instanceof ASTFunctionPointerDirectDeclarator) {
                if (n.jjtGetChild(0).jjtGetNumChildren() == 1) {
                    o = (SimpleNode) n.jjtGetChild(0).jjtGetChild(0);
                } else if (n.jjtGetChild(0).jjtGetNumChildren() > 1) {
                    o = (SimpleNode) n.jjtGetChild(0).jjtGetChild(1);
                } else {
                    return Boolean.FALSE;
                }
                if (o.getLastToken().kind == TMParserConstants.RBRACKET) {
                    return Boolean.TRUE;
                }
            }
        }
        return Boolean.FALSE;
    }

    private static void getDeclarationType(Node node, final StringBuffer type) {
        SimpleNode m;
        if (node instanceof ASTTypeSpecifier || node instanceof ASTMultiTypeSpecifier) {
            if (node.jjtGetNumChildren() > 0) {
                m = (SimpleNode) node.jjtGetChild(0);
                if (m instanceof ASTStructOrUnionSpecifier || m instanceof ASTEnumSpecifier) {
                    Token token = ((SimpleNode) node).getFirstToken().next;
                    if (token.kind == TMParserConstants.IDENTIFIER) {
                        if (type.length() > 0) {
                            type.append(" " + token.image);
                        } else {
                            type.append(token.image);
                        }
                    } else {
                        if (type.length() > 0) {
                            type.append(" " + ((SimpleNode) node).getFirstToken().image);
                        } else {
                            type.append(((SimpleNode) node).getFirstToken().image);
                        }
                    }
                }
            } else {
                if (type.length() > 0) {
                    type.append(" " + ((SimpleNode) node).getFirstToken().image);
                } else {
                    type.append(((SimpleNode) node).getFirstToken().image);
                }
            }
        } else if (node instanceof ASTDeclarationSpecifiers || node instanceof ASTMultiDeclarationSpecifiers) {
            for (int ord = 0; ord < node.jjtGetNumChildren(); ord++) {
                m = (SimpleNode) node.jjtGetChild(ord);
                getDeclarationType(m, type);
            }
        }
    }

    private static String[] getVariableModelDeclaration(Node node) {
        SimpleNode m, n;

        if (node.jjtGetNumChildren() > 2) {
            m = (SimpleNode) node.jjtGetChild(2).jjtGetChild(0).jjtGetChild(0);
            if (m.jjtGetNumChildren() == 1) {
                n = (SimpleNode) m.jjtGetChild(0);
            } else if (m.jjtGetNumChildren() > 1) {
                n = (SimpleNode) m.jjtGetChild(1);
            } else {
                return new String[2];
            }
            if (n instanceof ASTVariableDirectDeclarator) {
                if (((SimpleNode) n.getParent()).jjtGetChild(0) instanceof ASTPointer) {
                    return getVariableDeclarationPlus(((SimpleNode) n.getParent()).getFirstToken(), ((SimpleNode) n.getParent()).getLastToken(), 1);
                } else {
                    return getVariableDeclarationPlus(((SimpleNode) n.getParent()).getFirstToken(), ((SimpleNode) n.getParent()).getLastToken(), 0);
                }
            } else if (n instanceof ASTFunctionPointerDirectDeclarator) {
                if (n.jjtGetChild(0).jjtGetChild(0) instanceof ASTPointer) {
                    return getVariableDeclarationPlus(n.getFirstToken(), n.getLastToken(), 2);
                } else {
                    return getVariableDeclarationPlus(n.getFirstToken(), n.getLastToken(), 1);
                }
            }
        }
        return new String[2];
    }

    private static String[] getVariableDeclarationPlus(Token first, Token last, int skip) {
        Token next;
        int index = 0;
        boolean skippable = false;
        boolean isSeparators = true;
        String[] result = { null, null };
        StringBuffer decl = new StringBuffer();

        if (first != null && last != null) {
            next = first;
            while (true) {
                if (index == skip) {
                    result[0] = next.image;
                    if (decl.length() > 0 && decl.charAt(decl.length() - 1) != ' ') {
                        decl.append(" ");
                    }
                } else if (next.kind == TMParserConstants.IDENTIFIER) {
                    if (decl.length() > 0 && decl.charAt(decl.length() - 1) == ' ') {
                        decl.deleteCharAt(decl.length() - 1);
                    }
                } else {
                    if (next.kind == TMParserConstants.LPAREN || next.kind == TMParserConstants.RPAREN || next.kind == TMParserConstants.RBRACKET
                            || next.kind == TMParserConstants.COMMA) {
                        if (decl.length() > 0 && decl.charAt(decl.length() - 1) == ' ') {
                            decl.deleteCharAt(decl.length() - 1);
                        }
                    } else if (next.kind == TMParserConstants.LBRACKET) {
                        if (decl.length() > 1 && (decl.charAt(decl.length() - 1) == ' ' && decl.charAt(decl.length() - 2) == ']')) {
                            decl.deleteCharAt(decl.length() - 1);
                        }
                    }

                    if (next.kind == TMParserConstants.RBRACKET) {
                        skippable = false;
                    }
                    if (skippable) {
                        // skippable
                    } else {
                        if (isSeparators) {
                            decl.append(next.image);
                            isSeparators = false;
                        } else if (next.kind == TMParserConstants.LPAREN || next.kind == TMParserConstants.RPAREN || next.kind == TMParserConstants.LBRACKET) {
                            decl.append(next.image);
                            isSeparators = true;
                        } else {
                            decl.append(next.image + " ");
                            isSeparators = false;
                        }
                    }
                    if (next.kind == TMParserConstants.LBRACKET) {
                        skippable = true;
                    }
                }
                if (next == last)
                    break;
                next = next.next;
                index++;
            }
        }
        result[1] = decl.length() > 0 ? decl.toString().trim() : null;
        return result;
    }

    private static String getVariableModelInitializer(Node node) {
        SimpleNode m;

        if (node.jjtGetNumChildren() > 2 && node.jjtGetChild(2).jjtGetChild(0).jjtGetNumChildren() > 1) {
            m = (SimpleNode) node.jjtGetChild(2).jjtGetChild(0).jjtGetChild(1);
            if (m instanceof ASTInitializer) {
                return getVariableInitializer(m.getFirstToken(), m.getLastToken());
            }
        }
        return null;
    }

    private static String getVariableInitializer(Token first, Token last) {
        Token next;
        StringBuffer decl = new StringBuffer();

        if (first != null && last != null) {
            next = first;
            while (true) {
                decl.append(next.image);
                if (next == last)
                    break;
                next = next.next;
            }
        }
        return decl.length() > 0 ? decl.toString().trim() : null;
    }
}
