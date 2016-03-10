<jsp:include page="includes/head.jsp" />
<body>
    <h1>Create a new question</h1>
    <form action="/question-add" method="post" class="pure-form pure-form-stacked">
        <label>Category</label>
        <select name="category">
            <option value="java">Java</option>
            <option value="javascript">JavaScript</option>
            <option value="php">PHP</option>
        </select>
        <label>Level</label>
        <select name="level">
            <option value="basic">Beasic</option>
            <option value="intermediate">Intermediate</option>
            <option value="advanced">Advanced</option>
        </select>
        <label>Question</label>
        <textarea cols="20" rows="5" name="question"></textarea>
        <label>Answer</label>
        <textarea cols="20" rows="5" name="answer"></textarea>
        <label>Upload image</label>
        <input type="file" name="image" />
        <button type="submit" class="pure-button">Save</button>
</div>
</body>
</html>
