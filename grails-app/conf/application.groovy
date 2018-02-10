

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'projetpoiss.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'projetpoiss.UserRole'
grails.plugin.springsecurity.authority.className = 'projetpoiss.Role'
grails.plugin.springsecurity.requestMap.className = 'projetpoiss.UserRole'
grails.plugin.springsecurity.logout.postOnly=false


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
											  [pattern: '/index',                 access: ['ROLE_ADMIN','ROLE_MODERATOR','ROLE_USER']],
											  [pattern: '/index.gsp',             access: ['ROLE_ADMIN','ROLE_MODERATOR','ROLE_USER']],
											  [pattern: '/',                      access: ['permitAll']],
											  [pattern: '/user/**',               access: ['permitAll']],

											  [pattern: '/image/**',              access: ['permitAll']],
											  [pattern: '/groupe/index',          access: ['ROLE_ADMIN','ROLE_MODERATOR','ROLE_USER']],
											  [pattern: '/groupe/show/**',        access: ['ROLE_ADMIN','ROLE_MODERATOR','ROLE_USER']],
											  [pattern: '/groupe/create',         access: ['ROLE_ADMIN','ROLE_MODERATOR']],
											  [pattern: '/groupe/save',           access: ['ROLE_ADMIN','ROLE_MODERATOR']],
											  [pattern: '/groupe/edit/**',           access: ['ROLE_ADMIN','ROLE_MODERATOR']],
											  [pattern: '/groupe/update',         access: ['ROLE_ADMIN','ROLE_MODERATOR']],
											  [pattern: '/groupe/delete/**',         access: ['ROLE_ADMIN','ROLE_MODERATOR']],
                                              [pattern: '/poi/index',          access: ['ROLE_ADMIN','ROLE_MODERATOR','ROLE_USER']],
                                              [pattern: '/poi/show/**',        access: ['ROLE_ADMIN','ROLE_MODERATOR','ROLE_USER']],
                                              [pattern: '/poi/create',         access: ['ROLE_ADMIN','ROLE_MODERATOR']],
                                              [pattern: '/poi/save',           access: ['ROLE_ADMIN','ROLE_MODERATOR']],
                                              [pattern: '/poi/edit/**',           access: ['ROLE_ADMIN','ROLE_MODERATOR']],
                                              [pattern: '/poi/update',         access: ['ROLE_ADMIN','ROLE_MODERATOR']],
                                              [pattern: '/poi/delete/**',         access: ['ROLE_ADMIN','ROLE_MODERATOR']],

                                              [pattern: '/image/index',          access: ['ROLE_ADMIN','ROLE_MODERATOR','ROLE_USER']],
                                              [pattern: '/image/show/**',        access: ['ROLE_ADMIN','ROLE_MODERATOR','ROLE_USER']],
                                              [pattern: '/image/create',         access: ['ROLE_ADMIN','ROLE_MODERATOR']],
                                              [pattern: '/image/save',           access: ['ROLE_ADMIN','ROLE_MODERATOR']],
                                              [pattern: '/image/edit/**',           access: ['ROLE_ADMIN','ROLE_MODERATOR']],
                                              [pattern: '/image/update',         access: ['ROLE_ADMIN','ROLE_MODERATOR']],
                                              [pattern: '/image/delete/**',         access: ['ROLE_ADMIN','ROLE_MODERATOR']],

											  [pattern: '/role/**',               access: ['permitAll']],
											  [pattern: '/userrole/**',           access: ['permitAll']],
											  [pattern: '/shutdown',              access: ['permitAll']],
											  [pattern: '/assets/**',             access: ['permitAll']],
											  [pattern: '/**/js/**',              access: ['permitAll']],
											  [pattern: '/**/css/**',             access: ['permitAll']],
											  [pattern: '/**/images/**',          access: ['permitAll']],
											  [pattern: '/**/favicon.ico',        access: ['permitAll']],
											  [pattern: '/login/**',              access: ['permitAll']],
											  [pattern: '/logout/**',             access: ['permitAll']],
											  [pattern: '/api/login',             access: ['ROLE_ANONYMOUS']],
											  [pattern: '/oauth/access_token',    access: ['ROLE_ANONYMOUS']],
											  [pattern: '/',                      access: ['ROLE_ADMIN','ROLE_MODERATOR','ROLE_USER']],
											  [pattern: '/api/announcements/*',   access: ['ROLE_BOSS'], httpMethod: 'PUT']
]

