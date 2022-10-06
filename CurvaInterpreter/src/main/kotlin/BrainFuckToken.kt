package lakotka.anton.curva

import lakotka.anton.curva.BrainFuckToken.*

enum class BrainFuckToken {
    Increment,
    Decrement,
    IncPointer,
    DecPointer,
    WhileBegin,
    WhileEnd,
    Read,
    Write
}

/**
> = increases memory pointer, or moves the pointer to the right 1 block.
< = decreases memory pointer, or moves the pointer to the left 1 block.
+ = increases value stored at the block pointed to by the memory pointer
- = decreases value stored at the block pointed to by the memory pointer
[ = like c while(cur_block_value != 0) loop.
] = if block currently pointed to's value is not zero, jump back to [
, = like c getchar(). input 1 character.
. = like c putchar(). print 1 character to the console
 */
fun String.tokenizeBrainFuck(): List<BrainFuckToken> =
    map { char ->
        when(char) {
            '>' -> IncPointer
            '<' -> DecPointer
            '+' -> Increment
            '-' -> Decrement
            '[' -> WhileBegin
            ']' -> WhileEnd
            ',' -> Read
            '.' -> Write
            else -> kurwa("Unexpected token: '$char'")
        }
    }