/* Generated By:JJTree: Do not edit this line. ASTSelectionStatement.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=*,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package parser.textmodel.ast;

public
class ASTSelectionStatement extends SimpleNode {
  public ASTSelectionStatement(int id) {
    super(id);
  }

  public ASTSelectionStatement(TMParser p, int id) {
    super(p, id);
  }

  public static Node jjtCreate(int id) {
    return new ASTSelectionStatement(id);
  }

  public static Node jjtCreate(TMParser p, int id) {
    return new ASTSelectionStatement(p, id);
  }

  /** Accept the visitor. **/
  public Object jjtAccept(TMParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=be5e63a926d3721440ef165f76957544 (do not edit this line) */