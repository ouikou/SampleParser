/* Generated By:JJTree: Do not edit this line. ASTPostfixExpression.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=*,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package parser.textmodel.ast;

public
class ASTPostfixExpression extends SimpleNode {
  public ASTPostfixExpression(int id) {
    super(id);
  }

  public ASTPostfixExpression(TMParser p, int id) {
    super(p, id);
  }

  public static Node jjtCreate(int id) {
    return new ASTPostfixExpression(id);
  }

  public static Node jjtCreate(TMParser p, int id) {
    return new ASTPostfixExpression(p, id);
  }

  /** Accept the visitor. **/
  public Object jjtAccept(TMParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=cfcb04136ac641bfee9eb64581bcc3cd (do not edit this line) */
