/* Generated By:JJTree: Do not edit this line. ASTJumpStatement.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=*,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package parser.textmodel.ast;

public
class ASTJumpStatement extends SimpleNode {
  public ASTJumpStatement(int id) {
    super(id);
  }

  public ASTJumpStatement(TMParser p, int id) {
    super(p, id);
  }

  public static Node jjtCreate(int id) {
    return new ASTJumpStatement(id);
  }

  public static Node jjtCreate(TMParser p, int id) {
    return new ASTJumpStatement(p, id);
  }

  /** Accept the visitor. **/
  public Object jjtAccept(TMParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=63d5708f3f6367e614114ea583f3b7ac (do not edit this line) */
