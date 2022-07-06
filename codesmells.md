# Speculative Generality

A interface `Friends.java` só é utilizada na classe `Profile.java`, mas também poderia
ser utilizada na classe `Main.java`

# Duplicate Code
A classe `Main.java` possuí diversos ifs de verificação de login

# Long Method
- `Main.main`
- `Feed.viewFeed()`
- `Profile.manageRequestFriend();`
- `Profile.editProfile()`
- `Profile.printProfile()`
- `Community.enterCommunity()`
- `Message.sendCommunityMessage()`

# Dead Code
- `Profile.IdadeNaoPermitidaException()`
