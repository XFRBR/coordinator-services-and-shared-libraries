/**
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

# Demo main.tf
#
# This file is meant to show an example of what necessary environment-specific
# configuration is necessary in each environment. Terraform backend
# configuration cannot reference Terraform variables so this file must be
# customized for each environment.

terraform {
  # Note: the following lines should be uncommented in order to store Terraform
  # state in a remote backend.

  # backend "s3" {
  #   bucket = "<bucket name goes here, recommended suffix -mp-primary>"
  #   key    = "<key name goes here, recommended environment-name/domainrecords>.tfstate"
  #   region = "us-east-1"
  # }

  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 3.0"
    }
  }
}
