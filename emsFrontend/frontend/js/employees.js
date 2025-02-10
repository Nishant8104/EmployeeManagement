document.addEventListener('DOMContentLoaded', () => {
    const depNoInput = document.getElementById('depNo');
    const employeeList = document.getElementById('employee-list');

    // Fetch employees from API
    async function fetchEmployees(depNo = '') {
        try {
            const url = depNo ? 
                `http://localhost:9092/api/employees?depno=${depNo}` :
                'http://localhost:9092/api/employees';
            
            const response = await fetch(url);
            const employees = await response.json();
            
            renderEmployees(employees);
        } catch (error) {
            console.error('Error fetching employees:', error);
        }
    }

    // Render employees in table
    function renderEmployees(employees) {
        employeeList.innerHTML = employees.map(emp => `
            <tr>
                <td>${emp.id}</td>
                <td>${emp.name}</td>
                <td>${emp.department}</td>
                <td>${emp.email}</td>
                <td>${emp.position}</td>
            </tr>
        `).join('');
    }

    // Initial load
    fetchEmployees();

    // Filter input handler
    depNoInput.addEventListener('input', (e) => {
        fetchEmployees(e.target.value);
    });
});