/* Generated By:JJTree: Do not edit this line. ASTTextModelDeclaration.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=*,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package parser.textmodel.ast;

public
class ASTTextModelDeclaration extends SimpleNode {
  public ASTTextModelDeclaration(int id) {
    super(id);
  }

  public ASTTextModelDeclaration(TMParser p, int id) {
    super(p, id);
  }

  public static Node jjtCreate(int id) {
    return new ASTTextModelDeclaration(id);
  }

  public static Node jjtCreate(TMParser p, int id) {
    return new ASTTextModelDeclaration(p, id);
  }

  /** Accept the visitor. **/
  public Object jjtAccept(TMParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=fa48fd47d083967d324a09004a447b8b (do not edit this line) */
