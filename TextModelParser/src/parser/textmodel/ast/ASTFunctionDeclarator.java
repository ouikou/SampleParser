/* Generated By:JJTree: Do not edit this line. ASTFunctionDeclarator.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=*,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package parser.textmodel.ast;

public
class ASTFunctionDeclarator extends SimpleNode {
  public ASTFunctionDeclarator(int id) {
    super(id);
  }

  public ASTFunctionDeclarator(TMParser p, int id) {
    super(p, id);
  }

  public static Node jjtCreate(int id) {
    return new ASTFunctionDeclarator(id);
  }

  public static Node jjtCreate(TMParser p, int id) {
    return new ASTFunctionDeclarator(p, id);
  }

  /** Accept the visitor. **/
  public Object jjtAccept(TMParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=dc76c7f7d4bb77456d0a228e83879929 (do not edit this line) */