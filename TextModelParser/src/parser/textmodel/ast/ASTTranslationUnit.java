/* Generated By:JJTree: Do not edit this line. ASTTranslationUnit.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=*,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package parser.textmodel.ast;

public
class ASTTranslationUnit extends SimpleNode {
  public ASTTranslationUnit(int id) {
    super(id);
  }

  public ASTTranslationUnit(TMParser p, int id) {
    super(p, id);
  }

  public static Node jjtCreate(int id) {
    return new ASTTranslationUnit(id);
  }

  public static Node jjtCreate(TMParser p, int id) {
    return new ASTTranslationUnit(p, id);
  }

  /** Accept the visitor. **/
  public Object jjtAccept(TMParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=cb0af769be77a493280337b7833c14e2 (do not edit this line) */
