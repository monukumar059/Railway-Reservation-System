
  import React, { useState } from 'react';
  import axios from 'axios';
  import './Register.css';
  
  function Register() {
    const [formData, setFormData] = useState({
      user_id: '',
      password: '',
      confirmPassword: '',
      fullName: '',
      email:'',
      gender:'',
      date_of_birth:'',
      mobile_no:'',
      aadhar_no:'',
      pan_no:'',
      street_line:'',
      city:'',
      pincode:'',
      country:'',
      nationality:''
      
    


    });
  
    const handleInputChange = (event) => {
      setFormData({ ...formData, [event.target.name]: event.target.value });
    };
  
    const handleSubmit = async (event) => {
      event.preventDefault();
  
      if (formData.password !== formData.confirmPassword) {
        alert('Passwords do not match');
        return;
      }
  
      try {
        // Make the API call to the registration endpoint
        const response = await axios.post('http://127.0.0.1:8090/api/register', formData);
        console.log('Registration successful', response.data);
        // Add further handling based on the response from the server
  
      } catch (error) {
        console.error('Registration failed', error);
        // Add error handling as per your requirement
      }
    };
  
    return (
    <div>
      <h2>Registration Form</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="user_id">User ID:</label>
          <input type="text" id="user_id" name="user_id" value={formData.user_id} onChange={handleInputChange} required />
        </div>
        <br></br>
        <div>
          <label htmlFor="password">Password:</label>
          <input type="password" id="password" name="password" value={formData.password} onChange={handleInputChange} required />
        </div>
        <br></br>
        <div>
          <label htmlFor="confirmPassword">Confirm Password:</label>
          <input type="password" id="confirmPassword" name="confirmPassword" value={formData.confirmPassword} onChange={handleInputChange} required />
        </div>
        <br></br>
        <div>
          <label htmlFor="fullName">Full Name:</label>
          <input type="text" id="fullName" name="fullName" value={formData.fullName} onChange={handleInputChange} required />
        </div>
        <br></br>
        <div>
          <label htmlFor="email">Email:</label>
          <input type="email" id="email" name="email" value={formData.email} onChange={handleInputChange} required />
        </div>
        <br></br>
        <div>
          <label htmlFor="gender">Gender:</label>
          <input type="radio" name="gender" value="Male" id="option-1" onChange={handleInputChange} required />
          <label htmlFor="option-1">Male</label>
          <input type="radio" name="gender" value="Female" id="option-2" onChange={handleInputChange} required />
          <label htmlFor="option-2">Female</label>
          <input type="radio" name="gender" value="Others" id="option-3" onChange={handleInputChange} required />
          <label htmlFor="option-3">Others</label>
        </div>

          
        <br></br>
        <div>
          <label htmlFor="date_of_birth">D.O.B:</label>
          <input type="date" id="date_of_birth" name="date_of_birth" value={formData.date_of_birth} onChange={handleInputChange} required />
        </div>
        <br></br>
        <div>
          <label htmlFor="mobile_no">Mobile No.:</label>
          <input type="numeric" id="mobile_no" name="mobile_no" value={formData.mobile_no} onChange={handleInputChange} required />
        </div>
        <br></br>
        <div>
          <label htmlFor="aadhar_no">Aadhar No.:</label>
          <input type="text" id="aadhar_no" name="aadhar_no" value={formData.aadhar_no} onChange={handleInputChange} />
        </div>
        <br></br>
        <div>
          <label htmlFor="pan_no">Pan No.:</label>
          <input type="text" id="pan_no" name="pan_no" value={formData.pan_no} onChange={handleInputChange} required />
        </div>
        <br></br>
        <div>
          <label htmlFor="street_line ">Street Line:</label>
          <input type="text" id="street_line" name="street_line" value={formData.street_line} onChange={handleInputChange} required />
        </div>
        <br></br>
        <div>
          <label htmlFor="city ">City:</label>
          <input type="text" id="city" name="city" value={formData.city} onChange={handleInputChange} required />
        </div>
        <br></br>
        <div>
          <label htmlFor="pincode">Pincode:</label>
          <input type="text" id="pincode" name="pincode" value={formData.pincode} onChange={handleInputChange} required />
        </div>
        <br></br>
        <div>
          <label htmlFor="country">Country:</label>
          <input type="text" id="country" name="country" value={formData.country} onChange={handleInputChange} required />
        </div>
        <br></br>
        <div>
          <label htmlFor="nationality">Nationality:</label>
          <input type="text" id="nationality" name="nationality" value={formData.nationality} onChange={handleInputChange} required />
        </div>
        <br></br>
        <button variant="dark" type="Registe">
          Register
        </button>
        {/* <button type="submit">Register</button> */}
      </form>
    </div>
  );
}

// ReactDOM.render(<Register />, document.getElementById('root'));
export default Register;
