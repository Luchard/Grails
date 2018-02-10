import projetpoiss.UserPasswordEncoderListener

// Place your Spring DSL code here
beans = {
    userPasswordEncoderListener(UserPasswordEncoderListener)
    multipartResolver(org.springframework.web.multipart.commons.CommonsMultipartResolver){
        maxInMemorySize=10000000
        maxUploadSize=1000000000
        //uploadTempDir="/tmp"
    }
}

