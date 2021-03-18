
function openDialog() {
    $('#overlay').fadeIn('fast', function() {
        $('#popup').css('display','block');
        $('#popup').animate({'left':'30%'},500);
    });
}
 
function closeDialog(id) {
    $('#'+id).css('position','absolute');
    $('#'+id).animate({'left':'-100%'}, 500, function() {
        $('#'+id).css('position','fixed');
        $('#'+id).css('left','100%');
        $('#overlay').fadeOut('fast');
    });
}