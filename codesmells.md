# Speculative Generality

A interface `Friends.java` só é utilizada na classe `Profile.java`, mas também poderia
ser utilizada na classe `Main.java`

# Duplicate Code
A classe `Main.java` possuí diversos ifs de verificação de login

# Long Method
- `Profile.manageRequestFriend():` Foi aplicado o método extract method para corrigir esse smell. Dessa forma, o método manageRequestFriend originou outros
dois métodos (sendFriendRequest e checkFriendRequests)

# Dead Code
- `Profile.IdadeNaoPermitidaException()`
