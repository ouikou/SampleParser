/* Generated By:JJTree: Do not edit this line. ASTVariableDeclarationList.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=*,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package parser.textmodel.ast;

public
class ASTVariableDeclarationList extends SimpleNode {
  public ASTVariableDeclarationList(int id) {
    super(id);
  }

  public ASTVariableDeclarationList(TMParser p, int id) {
    super(p, id);
  }

  public static Node jjtCreate(int id) {
    return new ASTVariableDeclarationList(id);
  }

  public static Node jjtCreate(TMParser p, int id) {
    return new ASTVariableDeclarationList(p, id);
  }

  /** Accept the visitor. **/
  public Object jjtAccept(TMParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=8b09d2392e1549d3a87a8ab60194175f (do not edit this line) */