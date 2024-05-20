ruleset {
    ruleset('rulesets/basic.xml')
    ruleset('rulesets/braces.xml')
    ruleset('rulesets/comments.xml') {
        ClassJavadoc(enabled: false)
    }
    ruleset('rulesets/concurrency.xml')
    ruleset('rulesets/convention.xml') {
        CompileStatic(enabled: false)
        ImplicitClosureParameter(enabled: false) // brings extra complexity for the code
        ImplicitReturnStatement(enabled: false)
    }
    ruleset('rulesets/design.xml') {
        AbstractClassWithoutAbstractMethod(enabled: false)
        Instanceof(enabled: false)
    }
    ruleset('rulesets/dry.xml')
    ruleset('rulesets/exceptions.xml')
    ruleset('rulesets/formatting.xml') {
        Indentation(enabled: false) // issue with spock label indents
        LineLength(length: 180)
        SpaceAroundMapEntryColon(
            characterBeforeColonRegex: /./,
            characterAfterColonRegex: /\s/
        )
        ClosureStatementOnOpeningLineOfMultipleLineClosure(enabled: false) // Needs to be checked after release of this https://github.com/CodeNarc/CodeNarc/issues/474
    }
    ruleset('rulesets/generic.xml')
    ruleset('rulesets/grails.xml')
    ruleset('rulesets/groovyism.xml')
    ruleset('rulesets/imports.xml')
    ruleset('rulesets/jdbc.xml')
    ruleset('rulesets/junit.xml') {
        JUnitPublicProperty(enabled: false)
        JUnitPublicNonTestMethod(enabled: false)
    }
    ruleset('rulesets/logging.xml')
    ruleset('rulesets/naming.xml') {
        MethodName(enabled: false)
        FactoryMethodName(enabled: false)
        ParameterName(
            ignoreParameterNames: '_'
        )
    }
    ruleset('rulesets/security.xml') {
        JavaIoPackageAccess(enabled: false)
    }
    ruleset('rulesets/serialization.xml')
    ruleset('rulesets/size.xml')
    ruleset('rulesets/unnecessary.xml') {
        UnnecessaryGetter(checkIsMethods: false)
        UnnecessaryBooleanExpression(enabled: false) // spock issue - https://github.com/CodeNarc/CodeNarc/issues/329
    }
    ruleset('rulesets/unused.xml') {
        UnusedObject(doNotApplyToFilesMatching: '') // by default it's not applied to tests
    }
    ruleset('rulesets/enhanced.xml')
}