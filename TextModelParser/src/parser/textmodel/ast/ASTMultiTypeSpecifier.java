/* Generated By:JJTree: Do not edit this line. ASTMultiTypeSpecifier.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=*,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package parser.textmodel.ast;

public
class ASTMultiTypeSpecifier extends SimpleNode {
  public ASTMultiTypeSpecifier(int id) {
    super(id);
  }

  public ASTMultiTypeSpecifier(TMParser p, int id) {
    super(p, id);
  }

  public static Node jjtCreate(int id) {
    return new ASTMultiTypeSpecifier(id);
  }

  public static Node jjtCreate(TMParser p, int id) {
    return new ASTMultiTypeSpecifier(p, id);
  }

  /** Accept the visitor. **/
  public Object jjtAccept(TMParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=35365dcc6f6564902e166d5ea0a4bafa (do not edit this line) */
