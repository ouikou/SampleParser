/* Generated By:JJTree: Do not edit this line. ASTStructOrUnion.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=*,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package parser.textmodel.ast;

public
class ASTStructOrUnion extends SimpleNode {
  public ASTStructOrUnion(int id) {
    super(id);
  }

  public ASTStructOrUnion(TMParser p, int id) {
    super(p, id);
  }

  public static Node jjtCreate(int id) {
    return new ASTStructOrUnion(id);
  }

  public static Node jjtCreate(TMParser p, int id) {
    return new ASTStructOrUnion(p, id);
  }

  /** Accept the visitor. **/
  public Object jjtAccept(TMParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=12bb77dbede89b356b1222ba095b61f3 (do not edit this line) */
