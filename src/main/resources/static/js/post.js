post = {
    save: function () {
        let saveCategory;
        if ($('#notify').is(':checked')) {
            saveCategory = 'Notify';
        }else
            saveCategory = $('#createCategory').val() === '1' ? $('#categoryText').val() : $('#createCategory').val();

        let post = {
            title: $('#createTitle').val(),
            subtitle: $('#createSubtitle').val(),
            category: saveCategory,
            content: $('#createContent').val()
        };

        $.ajax({
            url: '/save',
            type: 'post',
            data: JSON.stringify(post),
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
        }).done(function () {
            location.href = "/?page=1";
        }).fail(function () {
            alert('Please try again');
        });
    },
    findById: function (id) {
        $.ajax({
            url: '/find',
            type: 'post',
            data: JSON.stringify(id),
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
        }).done(function (post) {
            $('#updateModal').data('id', id);
            $('#updateTitle').val(post.title);
            $('#updateSubtitle').val(post.subtitle);
            $('#updateCategory').val(post.category);
            $('#updateContent').val(post.content);
        }).fail(function () {
            alert('Please try again');
        })
    },
    update: function (page) {
        let post = {
            id: $('#updateModal').data('id'),
            title: $('#updateTitle').val(),
            subtitle: $('#updateSubtitle').val(),
            category: $('#updateCategory').val(),
            content: $('#updateContent').val()
        };

        $.ajax({
            url: '/update',
            type: 'put',
            data: JSON.stringify(post),
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
        }).done(function () {
            location.href = "/?page=" + page;
        }).fail(function () {
            alert('Please try again');
        });
    },
    deleteById: function (id) {
        $.ajax({
            url: '/delete',
            type: 'delete',
            data: JSON.stringify(id),
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
        }).done(function () {
            location.href = "../?page=1"
        }).fail(function () {
            alert('Please try again');
        })
    }
};

function save() {
    post.save();
}

function findById(id) {
    post.findById(id);
}

function update(page) {
    post.update(page);
}

function deleteById(id) {
    post.deleteById(id);
}

function directInput(value) {
    if (value === '1') {
        document.getElementById('categorySelect').style.display = 'none';
        document.getElementById('categoryInput').style.display = 'block';
    }
}

function notify(checked) {
    if (checked) document.getElementById('category').style.display = 'none';
}

function normal(checked) {
    if (checked) document.getElementById('category').style.display = 'block';
}