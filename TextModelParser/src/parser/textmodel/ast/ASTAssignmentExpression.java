/* Generated By:JJTree: Do not edit this line. ASTAssignmentExpression.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=*,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package parser.textmodel.ast;

public
class ASTAssignmentExpression extends SimpleNode {
  public ASTAssignmentExpression(int id) {
    super(id);
  }

  public ASTAssignmentExpression(TMParser p, int id) {
    super(p, id);
  }

  public static Node jjtCreate(int id) {
    return new ASTAssignmentExpression(id);
  }

  public static Node jjtCreate(TMParser p, int id) {
    return new ASTAssignmentExpression(p, id);
  }

  /** Accept the visitor. **/
  public Object jjtAccept(TMParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=d17370077c11d72dd43775be01080e73 (do not edit this line) */
