/*
// Licensed to Julian Hyde under one or more contributor license
// agreements. See the NOTICE file distributed with this work for
// additional information regarding copyright ownership.
//
// Julian Hyde licenses this file to you under the Apache License,
// Version 2.0 (the "License"); you may not use this file except in
// compliance with the License. You may obtain a copy of the License at:
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
*/
package org.eigenbase.resource;

import org.eigenbase.sql.validate.SqlValidatorException;
import org.eigenbase.util.EigenbaseContextException;
import org.eigenbase.util.EigenbaseException;

import static org.eigenbase.resource.Resources.*;

/**
 * Compiler-checked resources for the Eigenbase project.
 */
public interface EigenbaseNewResource {
  @BaseMessage("line {0,number,#}, column {1,number,#}")
  Inst parserContext(int a0, int a1);

  @BaseMessage("Illegal {0} literal {1}: {2}")
  ExInst<EigenbaseException> illegalLiteral(String a0, String a1, String a2);

  @BaseMessage("Length of identifier ''{0}'' must be less than or equal to {1,number,#} characters")
  ExInst<EigenbaseException> identifierTooLong(String a0, int a1);

  @BaseMessage("not in format ''{0}''")
  Inst badFormat(String a0);

  @BaseMessage("BETWEEN operator has no terminating AND")
  ExInst<SqlValidatorException> betweenWithoutAnd();

  @BaseMessage("Illegal INTERVAL literal {0}; at {1}")
  @Property(name = "SQLSTATE", value = "42000")
  ExInst<EigenbaseException> illegalIntervalLiteral(String a0, String a1);

  @BaseMessage("Illegal expression. Was expecting \"(DATETIME - DATETIME) INTERVALQUALIFIER\"")
  ExInst<EigenbaseException> illegalMinusDate();

  @BaseMessage("Illegal overlaps expression. Was expecting expression on the form \"(DATETIME, EXPRESSION) OVERLAPS (DATETIME, EXPRESSION)\"")
  ExInst<EigenbaseException> illegalOverlaps();

  @BaseMessage("Non-query expression encountered in illegal context")
  ExInst<EigenbaseException> illegalNonQueryExpression();

  @BaseMessage("Query expression encountered in illegal context")
  ExInst<EigenbaseException> illegalQueryExpression();

  @BaseMessage("CURSOR expression encountered in illegal context")
  ExInst<EigenbaseException> illegalCursorExpression();

  @BaseMessage("ORDER BY unexpected")
  ExInst<EigenbaseException> illegalOrderBy();

  @BaseMessage("Illegal binary string {0}")
  ExInst<EigenbaseException> illegalBinaryString(String a0);

  @BaseMessage("''FROM'' without operands preceding it is illegal")
  ExInst<EigenbaseException> illegalFromEmpty();

  @BaseMessage("ROW expression encountered in illegal context")
  ExInst<EigenbaseException> illegalRowExpression();

  @BaseMessage("TABLESAMPLE percentage must be between 0 and 100, inclusive")
  @Property(name = "SQLSTATE", value = "2202H")
  ExInst<EigenbaseException> invalidSampleSize();

  @BaseMessage("Unknown character set ''{0}''")
  ExInst<EigenbaseException> unknownCharacterSet(String a0);

  @BaseMessage("Failed to encode ''{0}'' in character set ''{1}''")
  ExInst<EigenbaseException> charsetEncoding(String a0, String a1);

  @BaseMessage("UESCAPE ''{0}'' must be exactly one character")
  ExInst<EigenbaseException> unicodeEscapeCharLength(String a0);

  @BaseMessage("UESCAPE ''{0}'' may not be hex digit, whitespace, plus sign, or double quote")
  ExInst<EigenbaseException> unicodeEscapeCharIllegal(String a0);

  @BaseMessage("UESCAPE cannot be specified without Unicode literal introducer")
  ExInst<EigenbaseException> unicodeEscapeUnexpected();

  @BaseMessage("Unicode escape sequence starting at character {0,number,#} is not exactly four hex digits")
  ExInst<SqlValidatorException> unicodeEscapeMalformed(int a0);

  @BaseMessage("No match found for function signature {0}")
  ExInst<SqlValidatorException> validatorUnknownFunction(String a0);

  @BaseMessage("Invalid number of arguments to function ''{0}''. Was expecting {1,number,#} arguments")
  ExInst<SqlValidatorException> invalidArgCount(String a0, int a1);

  @BaseMessage("At line {0,number,#}, column {1,number,#}")
  ExInstWithCause<EigenbaseContextException> validatorContextPoint(int a0,
      int a1);

  @BaseMessage("From line {0,number,#}, column {1,number,#} to line {2,number,#}, column {3,number,#}")
  ExInstWithCause<EigenbaseContextException> validatorContext(int a0, int a1,
      int a2,
      int a3);

  @BaseMessage("Cast function cannot convert value of type {0} to type {1}")
  ExInst<SqlValidatorException> cannotCastValue(String a0, String a1);

  @BaseMessage("Unknown datatype name ''{0}''")
  ExInst<SqlValidatorException> unknownDatatypeName(String a0);

  @BaseMessage("Values passed to {0} operator must have compatible types")
  ExInst<SqlValidatorException> incompatibleValueType(String a0);

  @BaseMessage("Values in expression list must have compatible types")
  ExInst<SqlValidatorException> incompatibleTypesInList();

  @BaseMessage("Cannot apply {0} to the two different charsets {1} and {2}")
  ExInst<SqlValidatorException> incompatibleCharset(String a0, String a1,
      String a2);

  @BaseMessage("ORDER BY is only allowed on top-level SELECT")
  ExInst<SqlValidatorException> invalidOrderByPos();

  @BaseMessage("Unknown identifier ''{0}''")
  ExInst<SqlValidatorException> unknownIdentifier(String a0);

  @BaseMessage("Unknown field ''{0}''")
  ExInst<SqlValidatorException> unknownField(String a0);

  @BaseMessage("Unknown target column ''{0}''")
  ExInst<SqlValidatorException> unknownTargetColumn(String a0);

  @BaseMessage("Target column ''{0}'' is assigned more than once")
  ExInst<SqlValidatorException> duplicateTargetColumn(String a0);

  @BaseMessage("Number of INSERT target columns ({0,number}) does not equal number of source items ({1,number})")
  ExInst<SqlValidatorException> unmatchInsertColumn(int a0, int a1);

  @BaseMessage("Cannot assign to target field ''{0}'' of type {1} from source field ''{2}'' of type {3}")
  ExInst<SqlValidatorException> typeNotAssignable(String a0, String a1,
      String a2, String a3);

  @BaseMessage("Table ''{0}'' not found")
  ExInst<SqlValidatorException> tableNameNotFound(String a0);

  @BaseMessage("Column ''{0}'' not found in any table")
  ExInst<SqlValidatorException> columnNotFound(String a0);

  @BaseMessage("Column ''{0}'' not found in table ''{1}''")
  ExInst<SqlValidatorException> columnNotFoundInTable(String a0, String a1);

  @BaseMessage("Column ''{0}'' is ambiguous")
  ExInst<SqlValidatorException> columnAmbiguous(String a0);

  @BaseMessage("Operand {0} must be a query")
  ExInst<SqlValidatorException> needQueryOp(String a0);

  @BaseMessage("Parameters must be of the same type")
  ExInst<SqlValidatorException> needSameTypeParameter();

  @BaseMessage("Cannot apply ''{0}'' to arguments of type {1}. Supported form(s): {2}")
  ExInst<SqlValidatorException> canNotApplyOp2Type(String a0, String a1,
      String a2);

  @BaseMessage("Expected a boolean type")
  ExInst<SqlValidatorException> expectedBoolean();

  @BaseMessage("ELSE clause or at least one THEN clause must be non-NULL")
  ExInst<SqlValidatorException> mustNotNullInElse();

  @BaseMessage("Function ''{0}'' is not defined")
  ExInst<SqlValidatorException> functionUndefined(String a0);

  @BaseMessage("Encountered {0} with {1,number} parameter(s); was expecting {2}")
  ExInst<SqlValidatorException> wrongNumberOfParam(String a0, int a1,
      String a2);

  @BaseMessage("Illegal mixing of types in CASE or COALESCE statement")
  ExInst<SqlValidatorException> illegalMixingOfTypes();

  @BaseMessage("Invalid compare. Comparing (collation, coercibility): ({0}, {1} with ({2}, {3}) is illegal")
  ExInst<EigenbaseException> invalidCompare(String a0, String a1, String a2,
      String a3);

  @BaseMessage("Invalid syntax. Two explicit different collations ({0}, {1}) are illegal")
  ExInst<EigenbaseException> differentCollations(String a0, String a1);

  @BaseMessage("{0} is not comparable to {1}")
  ExInst<SqlValidatorException> typeNotComparable(String a0, String a1);

  @BaseMessage("Cannot compare values of types ''{0}'', ''{1}''")
  ExInst<SqlValidatorException> typeNotComparableNear(String a0, String a1);

  @BaseMessage("Wrong number of arguments to expression")
  ExInst<SqlValidatorException> wrongNumOfArguments();

  @BaseMessage("Operands {0} not comparable to each other")
  ExInst<SqlValidatorException> operandNotComparable(String a0);

  @BaseMessage("Types {0} not comparable to each other")
  ExInst<SqlValidatorException> typeNotComparableEachOther(String a0);

  @BaseMessage("Numeric literal ''{0}'' out of range")
  ExInst<SqlValidatorException> numberLiteralOutOfRange(String a0);

  @BaseMessage("Date literal ''{0}'' out of range")
  ExInst<SqlValidatorException> dateLiteralOutOfRange(String a0);

  @BaseMessage("String literal continued on same line")
  ExInst<SqlValidatorException> stringFragsOnSameLine();

  @BaseMessage("Table or column alias must be a simple identifier")
  ExInst<SqlValidatorException> aliasMustBeSimpleIdentifier();

  @BaseMessage("List of column aliases must have same degree as table; table has {0,number,#} columns {1}, whereas alias list has {2,number,#} columns")
  ExInst<SqlValidatorException> aliasListDegree(int a0, String a1, int a2);

  @BaseMessage("Duplicate name ''{0}'' in column alias list")
  ExInst<SqlValidatorException> aliasListDuplicate(String a0);

  @BaseMessage("INNER, LEFT, RIGHT or FULL join requires a condition (NATURAL keyword or ON or USING clause)")
  ExInst<SqlValidatorException> joinRequiresCondition();

  @BaseMessage("Cannot specify condition (NATURAL keyword, or ON or USING clause) following CROSS JOIN")
  ExInst<SqlValidatorException> crossJoinDisallowsCondition();

  @BaseMessage("Cannot specify NATURAL keyword with ON or USING clause")
  ExInst<SqlValidatorException> naturalDisallowsOnOrUsing();

  @BaseMessage("Column name ''{0}'' in USING clause is not unique on one side of join")
  ExInst<SqlValidatorException> columnInUsingNotUnique(String a0);

  @BaseMessage("Column ''{0}'' matched using NATURAL keyword or USING clause has incompatible types: cannot compare ''{1}'' to ''{2}''")
  ExInst<SqlValidatorException> naturalOrUsingColumnNotCompatible(String a0,
      String a1, String a2);

  @BaseMessage("Window ''{0}'' not found")
  ExInst<SqlValidatorException> windowNotFound(String a0);

  @BaseMessage("Expression ''{0}'' is not being grouped")
  ExInst<SqlValidatorException> notGroupExpr(String a0);

  @BaseMessage("Expression ''{0}'' is not in the select clause")
  ExInst<SqlValidatorException> notSelectDistinctExpr(String a0);

  @BaseMessage("Aggregate expression is illegal in {0} clause")
  ExInst<SqlValidatorException> aggregateIllegalInClause(String a0);

  @BaseMessage("Windowed aggregate expression is illegal in {0} clause")
  ExInst<SqlValidatorException> windowedAggregateIllegalInClause(String a0);

  @BaseMessage("Aggregate expression is illegal in GROUP BY clause")
  ExInst<SqlValidatorException> aggregateIllegalInGroupBy();

  @BaseMessage("Aggregate expressions cannot be nested")
  ExInst<SqlValidatorException> nestedAggIllegal();

  @BaseMessage("Aggregate expression is illegal in ORDER BY clause of non-aggregating SELECT")
  ExInst<SqlValidatorException> aggregateIllegalInOrderBy();

  @BaseMessage("{0} clause must be a condition")
  ExInst<SqlValidatorException> condMustBeBoolean(String a0);

  @BaseMessage("HAVING clause must be a condition")
  ExInst<SqlValidatorException> havingMustBeBoolean();

  @BaseMessage("OVER must be applied to aggregate function")
  ExInst<SqlValidatorException> overNonAggregate();

  @BaseMessage("Cannot override window attribute")
  ExInst<SqlValidatorException> cannotOverrideWindowAttribute();

  @BaseMessage("Column count mismatch in {0}")
  ExInst<SqlValidatorException> columnCountMismatchInSetop(String a0);

  @BaseMessage("Type mismatch in column {0,number} of {1}")
  ExInst<SqlValidatorException> columnTypeMismatchInSetop(int a0, String a1);

  @BaseMessage("Binary literal string must contain an even number of hexits")
  ExInst<SqlValidatorException> binaryLiteralOdd();

  @BaseMessage("Binary literal string must contain only characters ''0'' - ''9'', ''A'' - ''F''")
  ExInst<SqlValidatorException> binaryLiteralInvalid();

  @BaseMessage("Illegal interval literal format {0} for {1}")
  ExInst<SqlValidatorException> unsupportedIntervalLiteral(String a0,
      String a1);

  @BaseMessage("Interval field value {0,number} exceeds precision of {1} field")
  ExInst<SqlValidatorException> intervalFieldExceedsPrecision(Number a0,
      String a1);

  @BaseMessage("RANGE clause cannot be used with compound ORDER BY clause")
  ExInst<SqlValidatorException> compoundOrderByProhibitsRange();

  @BaseMessage("Data type of ORDER BY prohibits use of RANGE clause")
  ExInst<SqlValidatorException> orderByDataTypeProhibitsRange();

  @BaseMessage("Data Type mismatch between ORDER BY and RANGE clause")
  ExInst<SqlValidatorException> orderByRangeMismatch();

  @BaseMessage("Window ORDER BY expression of type DATE requires range of type INTERVAL")
  ExInst<SqlValidatorException> dateRequiresInterval();

  @BaseMessage("Window boundary must be constant")
  ExInst<SqlValidatorException> rangeOrRowMustBeConstant();

  @BaseMessage("ROWS value must be a non-negative integral constant")
  ExInst<SqlValidatorException> rowMustBeNonNegativeIntegral();

  @BaseMessage("Window specification must contain an ORDER BY clause")
  ExInst<SqlValidatorException> overMissingOrderBy();

  @BaseMessage("UNBOUNDED FOLLOWING cannot be specified for the lower frame boundary")
  ExInst<SqlValidatorException> badLowerBoundary();

  @BaseMessage("UNBOUNDED PRECEDING cannot be specified for the upper frame boundary")
  ExInst<SqlValidatorException> badUpperBoundary();

  @BaseMessage("Upper frame boundary cannot be PRECEDING when lower boundary is CURRENT ROW")
  ExInst<SqlValidatorException> currentRowPrecedingError();

  @BaseMessage("Upper frame boundary cannot be CURRENT ROW when lower boundary is FOLLOWING")
  ExInst<SqlValidatorException> currentRowFollowingError();

  @BaseMessage("Upper frame boundary cannot be PRECEDING when lower boundary is FOLLOWING")
  ExInst<SqlValidatorException> followingBeforePrecedingError();

  @BaseMessage("Window name must be a simple identifier")
  ExInst<SqlValidatorException> windowNameMustBeSimple();

  @BaseMessage("Duplicate window names not allowed")
  ExInst<SqlValidatorException> duplicateWindowName();

  @BaseMessage("Empty window specification not allowed")
  ExInst<SqlValidatorException> emptyWindowSpec();

  @BaseMessage("Duplicate window specification not allowed in the same window clause")
  ExInst<SqlValidatorException> dupWindowSpec();

  @BaseMessage("ROW/RANGE not allowed with RANK or DENSE_RANK functions")
  ExInst<SqlValidatorException> rankWithFrame();

  @BaseMessage("RANK or DENSE_RANK functions require ORDER BY clause in window specification")
  ExInst<SqlValidatorException> funcNeedsOrderBy();

  @BaseMessage("PARTITION BY not allowed with existing window reference")
  ExInst<SqlValidatorException> partitionNotAllowed();

  @BaseMessage("ORDER BY not allowed in both base and referenced windows")
  ExInst<SqlValidatorException> orderByOverlap();

  @BaseMessage("Referenced window cannot have framing declarations")
  ExInst<SqlValidatorException> refWindowWithFrame();

  @BaseMessage("Type ''{0}'' is not supported")
  ExInst<SqlValidatorException> typeNotSupported(String a0);

  @BaseMessage("DISTINCT/ALL not allowed with {0} function")
  ExInst<SqlValidatorException> functionQuantifierNotAllowed(String a0);

  @BaseMessage("Not allowed to perform {0} on {1}")
  ExInst<SqlValidatorException> accessNotAllowed(String a0, String a1);

  @BaseMessage("The {0} function does not support the {1} data type.")
  ExInst<SqlValidatorException> minMaxBadType(String a0, String a1);

  @BaseMessage("Only scalar subqueries allowed in select list.")
  ExInst<SqlValidatorException> onlyScalarSubqueryAllowed();

  @BaseMessage("Ordinal out of range")
  ExInst<SqlValidatorException> orderByOrdinalOutOfRange();

  @BaseMessage("Window has negative size")
  ExInst<SqlValidatorException> windowHasNegativeSize();

  @BaseMessage("UNBOUNDED FOLLOWING window not supported")
  ExInst<SqlValidatorException> unboundedFollowingWindowNotSupported();

  @BaseMessage("Cannot use DISALLOW PARTIAL with window based on RANGE")
  ExInst<SqlValidatorException> cannotUseDisallowPartialWithRange();

  @BaseMessage("Interval leading field precision ''{0,number,#}'' out of range for {1}")
  ExInst<SqlValidatorException> intervalStartPrecisionOutOfRange(int a0,
      String a1);

  @BaseMessage("Interval fractional second precision ''{0,number,#}'' out of range for {1}")
  ExInst<SqlValidatorException> intervalFractionalSecondPrecisionOutOfRange(
      int a0, String a1);

  @BaseMessage("Duplicate relation name ''{0}'' in FROM clause")
  ExInst<SqlValidatorException> fromAliasDuplicate(String a0);

  @BaseMessage("Duplicate column name ''{0}'' in output")
  ExInst<SqlValidatorException> duplicateColumnName(String a0);

  @BaseMessage("Duplicate name ''{0}'' in column list")
  ExInst<SqlValidatorException> duplicateNameInColumnList(String a0);

  @BaseMessage("Internal error: {0}")
  ExInst<EigenbaseException> internal(String a0);

  @BaseMessage("Argument to function ''{0}'' must be a literal")
  ExInst<SqlValidatorException> argumentMustBeLiteral(String a0);

  @BaseMessage("Argument to function ''{0}'' must be a positive integer literal")
  ExInst<SqlValidatorException> argumentMustBePositiveInteger(String a0);

  @BaseMessage("Validation Error: {0}")
  ExInst<EigenbaseException> validationError(String a0);

  @BaseMessage("Locale ''{0}'' in an illegal format")
  ExInst<EigenbaseException> illegalLocaleFormat(String a0);

  @BaseMessage("Argument to function ''{0}'' must not be NULL")
  ExInst<SqlValidatorException> argumentMustNotBeNull(String a0);

  @BaseMessage("Illegal use of ''NULL''")
  ExInst<SqlValidatorException> nullIllegal();

  @BaseMessage("Illegal use of dynamic parameter")
  ExInst<SqlValidatorException> dynamicParamIllegal();

  @BaseMessage("''{0}'' is not a valid boolean value")
  ExInst<EigenbaseException> invalidBoolean(String a0);

  @BaseMessage("Argument to function ''{0}'' must be a valid precision between ''{1,number,#}'' and ''{2,number,#}''")
  ExInst<SqlValidatorException> argumentMustBeValidPrecision(String a0, int a1,
      int a2);

  @BaseMessage("''{0}'' is not a valid datetime format")
  ExInst<EigenbaseException> invalidDatetimeFormat(String a0);

  @BaseMessage("Cannot explicitly insert value into IDENTITY column ''{0}'' which is ALWAYS GENERATED")
  ExInst<EigenbaseException> insertIntoAlwaysGenerated(String a0);

  @BaseMessage("Argument to function ''{0}'' must have a scale of 0")
  ExInst<EigenbaseException> argumentMustHaveScaleZero(String a0);

  @BaseMessage("Statement preparation aborted")
  ExInst<EigenbaseException> preparationAborted();

  @BaseMessage("SELECT DISTINCT not supported")
  @Property(name = "FeatureDefinition", value = "SQL:2003 Part 2 Annex F")
  Feature sQLFeature_E051_01();

  @BaseMessage("EXCEPT not supported")
  @Property(name = "FeatureDefinition", value = "SQL:2003 Part 2 Annex F")
  Feature sQLFeature_E071_03();

  @BaseMessage("UPDATE not supported")
  @Property(name = "FeatureDefinition", value = "SQL:2003 Part 2 Annex F")
  Feature sQLFeature_E101_03();

  @BaseMessage("Transactions not supported")
  @Property(name = "FeatureDefinition", value = "SQL:2003 Part 2 Annex F")
  Feature sQLFeature_E151();

  @BaseMessage("INTERSECT not supported")
  @Property(name = "FeatureDefinition", value = "SQL:2003 Part 2 Annex F")
  Feature sQLFeature_F302();

  @BaseMessage("MERGE not supported")
  @Property(name = "FeatureDefinition", value = "SQL:2003 Part 2 Annex F")
  Feature sQLFeature_F312();

  @BaseMessage("Basic multiset not supported")
  @Property(name = "FeatureDefinition", value = "SQL:2003 Part 2 Annex F")
  Feature sQLFeature_S271();

  @BaseMessage("TABLESAMPLE not supported")
  @Property(name = "FeatureDefinition", value = "SQL:2003 Part 2 Annex F")
  Feature sQLFeature_T613();

  @BaseMessage("Execution of a new autocommit statement while a cursor is still open on same connection is not supported")
  @Property(name = "FeatureDefinition", value = "Eigenbase-defined")
  ExInst<EigenbaseException>
  sQLConformance_MultipleActiveAutocommitStatements();

  @BaseMessage("Descending sort (ORDER BY DESC) not supported")
  @Property(name = "FeatureDefinition", value = "Eigenbase-defined")
  Feature sQLConformance_OrderByDesc();

  @BaseMessage("Sharing of cached statement plans not supported")
  @Property(name = "FeatureDefinition", value = "Eigenbase-defined")
  ExInst<EigenbaseException> sharedStatementPlans();

  @BaseMessage("TABLESAMPLE SUBSTITUTE not supported")
  @Property(name = "FeatureDefinition", value = "Eigenbase-defined")
  Feature sQLFeatureExt_T613_Substitution();

  @BaseMessage("Personality does not maintain table''s row count in the catalog")
  @Property(name = "FeatureDefinition", value = "Eigenbase-defined")
  ExInst<EigenbaseException> personalityManagesRowCount();

  @BaseMessage("Personality does not support snapshot reads")
  @Property(name = "FeatureDefinition", value = "Eigenbase-defined")
  ExInst<EigenbaseException> personalitySupportsSnapshots();

  @BaseMessage("Personality does not support labels")
  @Property(name = "FeatureDefinition", value = "Eigenbase-defined")
  ExInst<EigenbaseException> personalitySupportsLabels();

  @BaseMessage("Require at least 1 argument")
  ExInst<SqlValidatorException> requireAtLeastOneArg();

  @BaseMessage("Map requires at least 2 arguments")
  ExInst<SqlValidatorException> mapRequiresTwoOrMoreArgs();

  @BaseMessage("Map requires an even number of arguments")
  ExInst<SqlValidatorException> mapRequiresEvenArgCount();

  @BaseMessage("Incompatible types")
  ExInst<SqlValidatorException> incompatibleTypes();

  @BaseMessage("Number of columns must match number of query columns")
  ExInst<SqlValidatorException> columnCountMismatch();

  @BaseMessage("Column has duplicate column name ''{0}'' and no column list specified")
  ExInst<SqlValidatorException> duplicateColumnAndNoColumnList(String s);
}
