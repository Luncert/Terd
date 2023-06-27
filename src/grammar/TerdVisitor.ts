// Generated from src/grammar/Terd.g4 by ANTLR 4.9.0-SNAPSHOT


import { ParseTreeVisitor } from "antlr4ts/tree/ParseTreeVisitor";

import { CommandContext } from "./TerdParser";
import { ExecutableContext } from "./TerdParser";
import { ArgumentsContext } from "./TerdParser";
import { ArgumentContext } from "./TerdParser";
import { OptionContext } from "./TerdParser";
import { OptionWithArgumentContext } from "./TerdParser";


/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by `TerdParser`.
 *
 * @param <Result> The return type of the visit operation. Use `void` for
 * operations with no return type.
 */
export interface TerdVisitor<Result> extends ParseTreeVisitor<Result> {
	/**
	 * Visit a parse tree produced by `TerdParser.command`.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	visitCommand?: (ctx: CommandContext) => Result;

	/**
	 * Visit a parse tree produced by `TerdParser.executable`.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	visitExecutable?: (ctx: ExecutableContext) => Result;

	/**
	 * Visit a parse tree produced by `TerdParser.arguments`.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	visitArguments?: (ctx: ArgumentsContext) => Result;

	/**
	 * Visit a parse tree produced by `TerdParser.argument`.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	visitArgument?: (ctx: ArgumentContext) => Result;

	/**
	 * Visit a parse tree produced by `TerdParser.option`.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	visitOption?: (ctx: OptionContext) => Result;

	/**
	 * Visit a parse tree produced by `TerdParser.optionWithArgument`.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	visitOptionWithArgument?: (ctx: OptionWithArgumentContext) => Result;
}

