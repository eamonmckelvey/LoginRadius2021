var commonOptions = {};
commonOptions.apiKey = "4e59164d-9098-4e3a-abe2-2c29d2cee9b6"; // Fill in
commonOptions.appName = "eamonsapp"; // Fill in
commonOptions.sott = "<SOTT>"; // Fill in
commonOptions.hashTemplate = true;
commonOptions.formValidationMessage = true;
commonOptions.verificationUrl = window.location.href.slice(0, window.location.href.lastIndexOf('/')).concat("/loginscreen");
commonOptions.resetPasswordUrl = window.location.href.slice(0, window.location.href.lastIndexOf('/')).concat("/loginscreen");
var LRObject = new LoginRadiusV2(commonOptions);