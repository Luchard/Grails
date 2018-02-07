

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'projetpoiss.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'projetpoiss.UserRole'
grails.plugin.springsecurity.authority.className = 'projetpoiss.Role'
grails.plugin.springsecurity.requestMap.className = 'projetpoiss.UserRole'


grails.plugin.springsecurity.securityConfigType = 'InterceptUrlMap'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
		[pattern: '/',               access: ['permitAll']],
		[pattern: '/error',          access: ['permitAll']],
		[pattern: '/index',          access: ['permitAll']],
		[pattern: '/index.gsp',      access: ['permitAll']],
		[pattern: '/shutdown',       access: ['permitAll']],
		[pattern: '/assets/**',      access: ['permitAll']],
		[pattern: '/**/js/**',       access: ['permitAll']],
		[pattern: '/**/css/**',      access: ['permitAll']],
		[pattern: '/**/images/**',   access: ['permitAll']],
		[pattern: '/**/favicon.ico', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
		[pattern: '/assets/**',      filters: 'none'],
		[pattern: '/**/js/**',       filters: 'none'],
		[pattern: '/**/css/**',      filters: 'none'],
		[pattern: '/**/images/**',   filters: 'none'],
		[pattern: '/**/favicon.ico', filters: 'none'],
		[pattern: '/api/**',filters: 'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter,-rememberMeAuthenticationFilter'],
		[pattern: '/**',             filters: 'JOINED_FILTERS,-restTokenValidationFilter,-restExceptionTranslationFilter']
]



grails.plugin.springsecurity.interceptUrlMap=[
											  [pattern: '/error',                 access: ['permitAll']],
											  [pattern: '/index',                 access: ['permitAll']],
											  [pattern: '/index.gsp',             access: ['permitAll']],
											  [pattern: '/',                      access: ['permitAll']],
											  [pattern: '/user/**',               access: ['permitAll']],
											  [pattern: '/poi/**',                access: ['permitAll']],
											  [pattern: '/image/**',              access: ['permitAll']],
											  [pattern: '/groupe/**',             access: ['permitAll']],
											  [pattern: '/userrole/**',           access: ['permitAll']],
											  [pattern: '/shutdown',              access: ['permitAll']],
											  [pattern: '/assets/**',             access: ['permitAll']],
											  [pattern: '/**/js/**',              access: ['permitAll']],
											  [pattern: '/**/css/**',             access: ['permitAll']],
											  [pattern: '/**/images/**',          access: ['permitAll']],
											  [pattern: '/**/favicon.ico',        access: ['permitAll']],
											  [pattern: '/login/**',              access: ['permitAll']],
											  [pattern: '/logout',                access: ['permitAll']],
											  [pattern: '/logout/**',             access: ['permitAll']],
											  [pattern: '/api/login',             access: ['ROLE_ANONYMOUS']],
											  [pattern: '/oauth/access_token',    access: ['ROLE_ANONYMOUS']],
											  [pattern: '/',                      access: ['ROLE_ADMIN']],
											  [pattern: '/api/announcements/*',   access: ['ROLE_BOSS'], httpMethod: 'PUT']
]

