<%--
  ~ MIT License
  ~
  ~ Copyright (c) 2023 Joel Schaltenbrand.
  ~
  ~ Permission is hereby granted, free of charge, to any person obtaining
  ~ a copy of this software and associated documentation files (the
  ~ "Software"), to deal in the Software without restriction, including
  ~ without limitation the rights to use, copy, modify, merge, publish,
  ~ distribute, sublicense, and/or sell copies of the Software, and to
  ~ permit persons to whom the Software is furnished to do so, subject to
  ~ the following conditions:
  ~
  ~ The above copyright notice and this permission notice shall be included in all copies or
  ~ substantial portions of the Software.
  ~
  ~ THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
  ~ EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
  ~ MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
  ~ NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS
  ~ BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
  ~ ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
  ~ CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
  ~ SOFTWARE.
  --%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Calculator</title>
    <link href="favicon.png" rel="icon" type="image/png">
    <meta content="width=device-width, initial-scale=1" name="viewport">
    <link crossorigin="anonymous" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" rel="stylesheet">
    <link href="styles.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <table id="calc">
                <tr>
                    <td colspan="3"><input id="result" readonly type="text">
                    </td>
                    <td><input class="btn btn-danger" type="button" value="c"></td>
                </tr>
                <tr>
                    <td><input class="btn btn-primary" type="button" value="7"></td>
                    <td><input class="btn btn-primary" type="button" value="8"></td>
                    <td><input class="btn btn-primary" type="button" value="9"></td>
                    <td><input class="btn btn-warning" type="button" value="/"></td>
                </tr>
                <tr>
                    <td><input class="btn btn-primary" type="button" value="4"></td>
                    <td><input class="btn btn-primary" type="button" value="5"></td>
                    <td><input class="btn btn-primary" type="button" value="6"></td>
                    <td><input class="btn btn-warning" type="button" value="*"></td>
                </tr>
                <tr>
                    <td><input class="btn btn-primary" type="button" value="1"></td>
                    <td><input class="btn btn-primary" type="button" value="2"></td>
                    <td><input class="btn btn-primary" type="button" value="3"></td>
                    <td><input class="btn btn-warning" type="button" value="-"></td>
                </tr>
                <tr>
                    <td><input class="btn btn-primary" type="button" value="0"></td>
                    <td><input class="btn btn-primary" type="button" value="."></td>
                    <td><input class="btn btn-success" type="button" value="="></td>
                    <td><input class="btn btn-warning" type="button" value="+"></td>
                </tr>
            </table>
        </div>
    </div>
</div>
</body>
<script crossorigin="anonymous"
        integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g="
        src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<script crossorigin="anonymous"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="main.js"></script>
</html>
