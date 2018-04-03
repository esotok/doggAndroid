node {

    stage 'Checkout'
    checkout scm

    stage 'Compile'
    sh "./gradlew compileDebugJava"

    stage 'Build'
    sh "./gradlew assembleRelease"

    stage 'Release'
    archiveArtifacts artifacts: 'app/**/*.apk', fingerprint: true
}
