const deleteButtons = document.querySelectorAll("button.delete-op");
deleteButtons.forEach((deleteButton) => {
    deleteButton.addEventListener("click", (event) => {
        const id = deleteButton.getAttribute("data-id");
        fetch(`/api/authors/${id}`, {
            method:"DELETE"
        }).then((res) => {
            if(res.status >= 200 && res.status < 400) {
                window.location.reload();
            } else {
                return res.json();
            }}).then((error) => {
                    const alertMessage = document.querySelector("#alertMessage");
                    
                    const alertElement = document.createElement("div");
                    alertElement.classList.add("alert", "alert-danger", "alert-dismissable");
                    alertElement.role="alert";
                    alertElement.innerHTML = `
                    <div class ="d-flex flex-column justify-content-center align-items-center">
                        <div class="my-2">Status: ${error.status}</div>
                        <div class="my-2">Error: ${error.message}</div>
                            <button type="button" class="btn btn-danger close" data-dismiss="alert" aria-label="Close">
                            Close
                            </button>
                    </div>
                    `;
                    alertMessage.appendChild(alertElement);
            })
    })
})