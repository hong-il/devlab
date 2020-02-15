comment = {
    commentSave: function (postId) {
        let comment = {
            content: $('#createComment').val(),
            postId: postId
        };

        $.ajax({
            url: '/commentSave',
            type: 'post',
            data: JSON.stringify(comment),
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
        }).done(function () {
            location.href = "/post/" + postId;
        }).fail(function () {
            alert('Please try again');
        });
    }
};

function commentSave(postId) {
    comment.commentSave(postId);
}