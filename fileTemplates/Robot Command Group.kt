package ${PACKAGE_NAME}

import org.usfirst.frc.team4322.commandv2.*

object ${NAME} {
    operator fun invoke() : Command {
        return group {
            
            // Example Sequential
            sequential {
                add(/*MyCommand()*/)
                add(/*MyCommand()*/)
                // Example Router (must be placed in sequencing block).
                router {
                    if(true) {
                        /*MyCommand()*/  
                    }
                    else
                    {
                        /*MyCommand()*/
                    }
                })
            }
            
            // Example Parallel
            parallel {
                add(/*MyCommand()*/)
                add(/*MyCommand()*/)
            }
            

        }
    }
}