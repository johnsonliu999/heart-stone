import React from 'react'

const UserView = (props) => (
    <div>
        <h1>User View</h1>
        <div>
            <img src={window.user.picture} alt=""/>
            <table>
                <tr><td>Name</td><td>{window.user.name}</td></tr>
                <tr><td>Email</td><td>{window.use.email}</td></tr>
            </table>
        </div>
    </div>
);

export default UserView;