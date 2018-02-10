package projetpoiss

class BootStrap {

    def init = { servletContext ->

        def adminRole = new Role(authority: 'ROLE_ADMIN').save()
        def userRole = new Role(authority:'ROLE_USER').save()
        def moderatorRole = new Role(authority:'ROLE_MODERATOR').save()
        def testUser = new User(username: 'me' , password: 'password', nom: 'Orelus' , prenom: 'Luchard').save()

        def testUser1 = new User(username: 'lulu' , password: 'password' , nom: 'Orelus' , prenom: 'Luchard').save()

        def testUser2 = new User(username: 'stephan' , password: 'password' , nom: 'Alexis' , prenom: 'Jean Stéphane').save()

        UserRole.create(testUser , adminRole , true)
        UserRole.create(testUser1 , userRole , true)
        UserRole.create(testUser2 , moderatorRole , true)

       // assert User.count ==2
      //  assert Role.count == 2
        //assert UserRole.count ==2




      //  def groupeAlpha = new Groupe(nom: "Groupe Alpha").save(flush:true, failOnError:true)
//groupeAlpha.image(new Image(filename: 'image.png'));
        //groupeAlpha.addToPois(new Poi(nom: "POI Alpha", latitude: 17.12, longitude: 7.14))

        //groupeAlpha.save(flush:true, failOnError:true)
    }
    def destroy = {
    }
}
