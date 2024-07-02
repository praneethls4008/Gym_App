import * as React from 'react';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';
import Link from '@mui/material/Link';
import Paper from '@mui/material/Paper';
import Box from '@mui/material/Box';
import Grid from '@mui/material/Grid';
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import Typography from '@mui/material/Typography';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import { Link as RouterLink } from "react-router-dom";
import axios from 'axios';
import bcrypt from 'bcryptjs/dist/bcrypt';
function Copyright(props) {
  return (
    <Typography variant="body2" color="text.secondary" align="center" {...props}>
      {'Copyright © '}
      <Link color="inherit" href="/">
        Home
      </Link>{' '}
      {new Date().getFullYear()}
      {'.'}
    </Typography>
  );
}

// TODO remove, this demo shouldn't need to reset the theme.

const defaultTheme = createTheme();

export default function SignIn({toast}) {
  const handleSubmit = (event) => {
    event.preventDefault();
    const data = new FormData(event.currentTarget);
    axios.get(`http://localhost:3000/user?email=${data.get('email')}`).then(response=>response.data[0].password).then(hash=>console.log(bcrypt.compareSync(data.get('password'), hash)))
    //toast.success(`signed in with ${data.get('email')}`)
    
  };

  return (
    <Grid item xs={12} sm={8} md={5} component={Paper} elevation={6} square sx={{
          backgroundColor: 'transparent',
          background: 'rgba(0, 0, 0, 0.6)',
          color: 'white !important' 
          }}>
          <Box
            sx={{
              my: 8,
              mx: 4,
              display: 'flex',
              flexDirection: 'column',
              alignItems: 'center',
            }}
          >
            <Avatar sx={{ m: 1, bgcolor: 'secondary.main' }}>
              <img src='public\profile.png'/>
            </Avatar>
            <Typography component="h1" variant="h5">
              Sign in
            </Typography>
            <Box component="form" noValidate onSubmit={handleSubmit} sx={{ mt: 1 }}>
              <TextField
                margin="normal"
                required
                fullWidth
                id="email"
                label="Email Address"
                name="email"
                autoComplete="email"
                sx={{ input: { color: 'white', borderColor: 'white'}, label: {color: 'white', opacity: 0.5}}}
              />
              <TextField
                margin="normal"
                required
                fullWidth
                name="password"
                label="Password"
                type="password"
                id="password"
                autoComplete="current-password"
                sx={{ input: { color: 'white', borderColor: 'white'}, label: {color: 'white', opacity: 0.5}}}
              />
              <FormControlLabel
                control={<Checkbox value="remember" color="primary" sx={{color: '#d4d4d4'}}/>}
                label="Remember me"
              />
              <Button
                type="submit"
                fullWidth
                variant="contained"
                sx={{ mt: 3, mb: 2 }}
              >
                Sign In
              </Button>
              <Grid container>
                <Grid item xs>
                  <Link href="#" variant="body2" sx={{color: '#d4d4d4'}}>
                    Forgot password?
                  </Link>
                </Grid>
                <Grid item>
                  <Link component={RouterLink} to="/signup" variant="body2" sx={{color: '#d4d4d4'}}>
                    {"Don't have an account? Sign Up"}
                  </Link>
                </Grid>
              </Grid>
              <Copyright sx={{ mt: 5, color: '#d4d4d4'}} />
            </Box>
          </Box>
        </Grid>
  );
}