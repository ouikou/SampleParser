/* Generated By:JJTree: Do not edit this line. ASTFunctionModelDeclaration.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=*,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package parser.textmodel.ast;

public
class ASTFunctionModelDeclaration extends SimpleNode {
  public ASTFunctionModelDeclaration(int id) {
    super(id);
  }

  public ASTFunctionModelDeclaration(TMParser p, int id) {
    super(p, id);
  }

  public static Node jjtCreate(int id) {
    return new ASTFunctionModelDeclaration(id);
  }

  public static Node jjtCreate(TMParser p, int id) {
    return new ASTFunctionModelDeclaration(p, id);
  }

  /** Accept the visitor. **/
  public Object jjtAccept(TMParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=0b0e6ce4df8d522d09256eabcb0d6010 (do not edit this line) */
