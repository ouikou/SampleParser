/* Generated By:JJTree: Do not edit this line. ASTShiftExpression.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=*,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package parser.textmodel.ast;

public
class ASTShiftExpression extends SimpleNode {
  public ASTShiftExpression(int id) {
    super(id);
  }

  public ASTShiftExpression(TMParser p, int id) {
    super(p, id);
  }

  public static Node jjtCreate(int id) {
    return new ASTShiftExpression(id);
  }

  public static Node jjtCreate(TMParser p, int id) {
    return new ASTShiftExpression(p, id);
  }

  /** Accept the visitor. **/
  public Object jjtAccept(TMParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=d574764cd40a79c23bac5ede30536dc3 (do not edit this line) */