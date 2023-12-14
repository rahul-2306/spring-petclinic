def test(message) {
    echo "the message is $(message)"
    sh 'print env'
}
