/* Generated By:JJTree: Do not edit this line. ASTcommentAnnoName.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=*,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package parser.textmodel.ast;

public
class ASTcommentAnnoName extends SimpleNode {
  public ASTcommentAnnoName(int id) {
    super(id);
  }

  public ASTcommentAnnoName(TMParser p, int id) {
    super(p, id);
  }

  public static Node jjtCreate(int id) {
    return new ASTcommentAnnoName(id);
  }

  public static Node jjtCreate(TMParser p, int id) {
    return new ASTcommentAnnoName(p, id);
  }

  /** Accept the visitor. **/
  public Object jjtAccept(TMParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=d495d7e5caab49242a7055a85240f93f (do not edit this line) */
