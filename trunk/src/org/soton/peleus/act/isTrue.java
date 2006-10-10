/**
 * 
 */
package org.soton.peleus.act;

import jason.asSemantics.InternalAction;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Literal;
import jason.asSyntax.Term;

import java.util.logging.Logger;

/**
 * @author frm05r
 *
 */
public class isTrue implements InternalAction {

	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(InternalAction.class.getName());
	/* (non-Javadoc)
	 * @see jason.asSemantics.InternalAction#execute(jason.asSemantics.TransitionSystem, jason.asSemantics.Unifier, jason.asSyntax.Term[])
	 */
	public boolean execute(TransitionSystem ts, Unifier un, Term[] args)
			throws Exception {
		logger.info("Belief Base: \n"+ts.getAg().getBS().getAllBeliefs());
		logger.info("Got "+args[0]);
		Literal literal = Literal.parseLiteral(args[0].toString());
		logger.info("Created "+literal);
		Literal lit = ts.getAg().getBS().contains(literal);
		logger.info("Beliefs "+lit);
		return (lit!= null);
	}

}
