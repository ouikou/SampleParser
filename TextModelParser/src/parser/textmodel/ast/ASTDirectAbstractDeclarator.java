/* Generated By:JJTree: Do not edit this line. ASTDirectAbstractDeclarator.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=true,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=*,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package parser.textmodel.ast;

public
class ASTDirectAbstractDeclarator extends SimpleNode {
  public ASTDirectAbstractDeclarator(int id) {
    super(id);
  }

  public ASTDirectAbstractDeclarator(TMParser p, int id) {
    super(p, id);
  }

  public static Node jjtCreate(int id) {
    return new ASTDirectAbstractDeclarator(id);
  }

  public static Node jjtCreate(TMParser p, int id) {
    return new ASTDirectAbstractDeclarator(p, id);
  }

  /** Accept the visitor. **/
  public Object jjtAccept(TMParserVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=b1180315afb6cec5998d70dc61b4df58 (do not edit this line) */
