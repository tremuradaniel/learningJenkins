job('NodeJS example') {
    scm {
        git('https://github.com/tremuradaniel/learningJenkins.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('DSL User')
            node / gitConfigEmail('tremuradaniel@gmail.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        shell("""
            cd $WORKSPACE/docker-demo
            npm install
        """)
    }
}
