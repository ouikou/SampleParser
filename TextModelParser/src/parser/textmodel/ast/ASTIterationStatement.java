/* Generated By:JJTree: Do not edit this line. ASTIterationStatement.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=*,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package parser.textmodel.ast;

public
class ASTIterationStatement extends SimpleNode {
  public ASTIterationStatement(int id) {
    super(id);
  }

  public ASTIterationStatement(TMParser p, int id) {
    super(p, id);
  }

  public static Node jjtCreate(int id) {
    return new ASTIterationStatement(id);
  }

  public static Node jjtCreate(TMParser p, int id) {
    return new ASTIterationStatement(p, id);
  }

  /** Accept the visitor. **/
  public Object jjtAccept(TMParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=ce6635d3ab7a3c12cd17b04e09bd7079 (do not edit this line) */
