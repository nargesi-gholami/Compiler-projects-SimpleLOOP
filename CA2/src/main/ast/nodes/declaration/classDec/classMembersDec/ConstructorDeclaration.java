package main.ast.nodes.declaration.classDec.classMembersDec;

import main.visitor.IVisitor;
import main.ast.nodes.expression.Identifier;

//line -> INITIALIZE
public class ConstructorDeclaration extends MethodDeclaration{

    public ConstructorDeclaration() {
        super();
    }

    @Override
    public String toString() {
        return "ConstructorDeclaration";
    }

    @Override
    public Identifier getMethodName() {
        return new Identifier("initialize");
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
