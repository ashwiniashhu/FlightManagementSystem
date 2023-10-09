import { User } from "./user";


describe('User', () => {
  it('should create an instance', () => {
    expect( new User('userName:any','userPassword:any','email:any', 'dob:any',' about:any', 'role:any')).toBeTruthy();
   });
});
