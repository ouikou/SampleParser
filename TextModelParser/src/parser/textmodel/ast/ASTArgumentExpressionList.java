/* Generated By:JJTree: Do not edit this line. ASTArgumentExpressionList.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=*,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package parser.textmodel.ast;

public
class ASTArgumentExpressionList extends SimpleNode {
  public ASTArgumentExpressionList(int id) {
    super(id);
  }

  public ASTArgumentExpressionList(TMParser p, int id) {
    super(p, id);
  }

  public static Node jjtCreate(int id) {
    return new ASTArgumentExpressionList(id);
  }

  public static Node jjtCreate(TMParser p, int id) {
    return new ASTArgumentExpressionList(p, id);
  }

  /** Accept the visitor. **/
  public Object jjtAccept(TMParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=26bf923e71f8273d676c039c2e7e58d8 (do not edit this line) */
