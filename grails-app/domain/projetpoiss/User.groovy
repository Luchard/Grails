package projetpoiss

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class User implements Serializable {

    private static final long serialVersionUID = 1

    String username
String nom
    String prenom
    String password
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    Set<Role> getAuthorities() {
        (UserRole.findAllByUser(this) as List<UserRole>)*.role as Set<Role>
    }

    static constraints = {
        prenom nullable: false, blank: false
        nom nullable: false, blank: false
        username nullable: false, blank: false, unique: true
        password nullable: false, blank: false, password: true



    }

    static mapping = {
	    password column: '`password`'
    }
}
