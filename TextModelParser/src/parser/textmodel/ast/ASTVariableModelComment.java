/* Generated By:JJTree: Do not edit this line. ASTVariableModelComment.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=*,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package parser.textmodel.ast;

public
class ASTVariableModelComment extends SimpleNode {
  public ASTVariableModelComment(int id) {
    super(id);
  }

  public ASTVariableModelComment(TMParser p, int id) {
    super(p, id);
  }

  public static Node jjtCreate(int id) {
    return new ASTVariableModelComment(id);
  }

  public static Node jjtCreate(TMParser p, int id) {
    return new ASTVariableModelComment(p, id);
  }

  /** Accept the visitor. **/
  public Object jjtAccept(TMParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=992b917dd41e1932eaf4fbacae9686cb (do not edit this line) */