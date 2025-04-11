import { Users } from "./users/users";

export class JwtResponse {
    constructor(
      public user: Users,
      public jwtToken: string
    ) {}
  }