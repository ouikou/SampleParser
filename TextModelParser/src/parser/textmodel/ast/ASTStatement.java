/* Generated By:JJTree: Do not edit this line. ASTStatement.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=*,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package parser.textmodel.ast;

public
class ASTStatement extends SimpleNode {
  public ASTStatement(int id) {
    super(id);
  }

  public ASTStatement(TMParser p, int id) {
    super(p, id);
  }

  public static Node jjtCreate(int id) {
    return new ASTStatement(id);
  }

  public static Node jjtCreate(TMParser p, int id) {
    return new ASTStatement(p, id);
  }

  /** Accept the visitor. **/
  public Object jjtAccept(TMParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=e742bbced503027908d50fe8796c0a83 (do not edit this line) */
