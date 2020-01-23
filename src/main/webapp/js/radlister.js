function showConfirmDelete(){
    var userconfirm = confirm("Are you sure you want to continue with deleting your account? This will also delete all associated ads!");
    if (!userconfirm){
        return false;
    } else {
        this.$('confirmationbutton').submit();
    }
}
function showConfirmDeleteAd(){
    var userconfirm = confirm("Are you sure you want to continue with deleting your ad?");
    if (!userconfirm){
        return false;
    } else {
        this.$('.confirmationbutton').submit();
    }
}




