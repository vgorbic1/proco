<p>Recommended Books:</p>
<ul>
<c:forEach items="${books}" var="book">
    <li>"${book[0]}" by ${book[2]} publisher: ${book[1]}.</li>
</c:forEach>
    </ul>
${bookTitle} ${bookAuthor} ${bookPublisher}