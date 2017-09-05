package org.openehr.expressions.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract definition of an operator for use in the Rules evaluator.
 *
 * Created by cnanjo on 5/20/16.
 */
public abstract class OperatorDefinition {

    /**
     * Unique identifier of this operator within the rules system.
     */
    private String identifier;
    /**
     * One or more symbols used to express the operator in textual form. This may include any unicode character.
     */
    private List<String> symbols;

    public OperatorDefinition() {
        symbols = new ArrayList<>();
    }

    /**
     *
     * @return Unique identifier of this operator within the rules system.
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     *
     * @param identifier Unique identifier of this operator within the rules system.
     */
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    /**
     *
     * @return One or more symbols used to express the operator in textual form. This may include any unicode character.
     */
    public List<String> getSymbols() {
        throw new UnsupportedOperationException();//TODO Implement
    }

    /**
     *
     * @param symbols One or more symbols used to express the operator in textual form. This may include any unicode character.
     */
    protected void setSymbols(List<String> symbols) {
        this.symbols = symbols;
    }

    /**
     * Adds a new symbol to this operator. All symbols added must be synonyms and can be unicode
     *
     * @param symbol
     */
    protected void addSymbol(String symbol) {
        this.symbols.add(symbol);
    }
}
