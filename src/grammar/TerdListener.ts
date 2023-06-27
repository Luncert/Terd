// Generated from src/grammar/Terd.g4 by ANTLR 4.9.0-SNAPSHOT


import { ParseTreeListener } from "antlr4ts/tree/ParseTreeListener";

import { CommandContext } from "./TerdParser";
import { ExecutableContext } from "./TerdParser";
import { ArgumentsContext } from "./TerdParser";
import { ArgumentContext } from "./TerdParser";
import { OptionContext } from "./TerdParser";
import { OptionWithArgumentContext } from "./TerdParser";


/**
 * This interface defines a complete listener for a parse tree produced by
 * `TerdParser`.
 */
export interface TerdListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by `TerdParser.command`.
	 * @param ctx the parse tree
	 */
	enterCommand?: (ctx: CommandContext) => void;
	/**
	 * Exit a parse tree produced by `TerdParser.command`.
	 * @param ctx the parse tree
	 */
	exitCommand?: (ctx: CommandContext) => void;

	/**
	 * Enter a parse tree produced by `TerdParser.executable`.
	 * @param ctx the parse tree
	 */
	enterExecutable?: (ctx: ExecutableContext) => void;
	/**
	 * Exit a parse tree produced by `TerdParser.executable`.
	 * @param ctx the parse tree
	 */
	exitExecutable?: (ctx: ExecutableContext) => void;

	/**
	 * Enter a parse tree produced by `TerdParser.arguments`.
	 * @param ctx the parse tree
	 */
	enterArguments?: (ctx: ArgumentsContext) => void;
	/**
	 * Exit a parse tree produced by `TerdParser.arguments`.
	 * @param ctx the parse tree
	 */
	exitArguments?: (ctx: ArgumentsContext) => void;

	/**
	 * Enter a parse tree produced by `TerdParser.argument`.
	 * @param ctx the parse tree
	 */
	enterArgument?: (ctx: ArgumentContext) => void;
	/**
	 * Exit a parse tree produced by `TerdParser.argument`.
	 * @param ctx the parse tree
	 */
	exitArgument?: (ctx: ArgumentContext) => void;

	/**
	 * Enter a parse tree produced by `TerdParser.option`.
	 * @param ctx the parse tree
	 */
	enterOption?: (ctx: OptionContext) => void;
	/**
	 * Exit a parse tree produced by `TerdParser.option`.
	 * @param ctx the parse tree
	 */
	exitOption?: (ctx: OptionContext) => void;

	/**
	 * Enter a parse tree produced by `TerdParser.optionWithArgument`.
	 * @param ctx the parse tree
	 */
	enterOptionWithArgument?: (ctx: OptionWithArgumentContext) => void;
	/**
	 * Exit a parse tree produced by `TerdParser.optionWithArgument`.
	 * @param ctx the parse tree
	 */
	exitOptionWithArgument?: (ctx: OptionWithArgumentContext) => void;
}

