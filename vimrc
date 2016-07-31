"VIM CONFIGURATION FILE MAC OSX
execute pathogen#infect()
syntax on
filetype plugin indent on
set number
"Kernel Linux Development
set colorcolumn=81
highlight ColorColumn ctermbg=Black ctermfg=DarkRed
highlight ExtraWhitespace ctermbg=red guibg=red
match ExtraWhitespace /\s\+$/
autocmd BufWinEnter * match ExtraWhitespace /\s\+$/
autocmd InsertEnter * match ExtraWhitespace /\s\+\%#\@<!$/
autocmd InsertLeave * match ExtraWhitespace /\s\+$/
autocmd BufWinLeave * call clearmatches()
"NerdTree option
map <C-n> :NERDTreeToggle<CR>
"Color option
set t_Co=256
set background=dark
if has('gui_running')
	colorscheme solarized
	let g:solarized_termcolors=256
else
	colorscheme hybrid
endif
highlight LineNr ctermfg=white guifg=#f5f5f5
"Omniautocomplete
set omnifunc=syntaxcomplete#Complete
set completeopt=longest,menuone
inoremap <expr> <CR> pumvisible() ? "\<C-y>" : "\<C-g>u\<CR>"
inoremap <expr> <C-n> pumvisible() ? '<C-n>' :
			\ '<C-n><C-r>=pumvisible() ? "\<lt>Down>" : ""<CR>'
inoremap <expr> <M-,> pumvisible() ? '<C-n>' :
			\ '<C-x><C-o><C-n><C-p><C-r>=pumvisible() ? "\<lt>Down>" : ""<CR>'
" Use Ctrl+Space for omni-completion
inoremap <expr> <C-Space> pumvisible() \|\| &omnifunc == '' ?
			\ "\<lt>C-n>" :
			\ "\<lt>C-x>\<lt>C-o><c-r>=pumvisible() ?" .
			\ "\"\\<lt>c-n>\\<lt>c-p>\\<lt>c-n>\" :" .
			\ "\" \\<lt>bs>\\<lt>C-n>\"\<CR>"
imap <C-@> <C-Space>
" Popup menu hightLight Group
highlight Pmenu ctermbg=13 guibg=DarkRed
highlight PmenuSel ctermbg=7 guibg=DarkBlue guifg=White
highlight PmenuSbar ctermbg=7 guibg=DarkGray
highlight PmenuThumb guibg=Black
" Enable global scope search
let OmniCpp_GlobalScopeSearch = 1
" Show function parameters
let OmniCpp_ShowPrototypeInAbbr = 1
" Show access information in pop-up menu
let OmniCpp_ShowAccess = 1
" Auto complete after '.'
let OmniCpp_MayCompleteDot = 1
" Auto complete after '->'
let OmniCpp_MayCompleteArrow = 1
" Auto complete after '::'
let OmniCpp_MayCompleteScope = 0
" Don't select first item in pop-up menu
let OmniCpp_SelectFirstItem = 0
"Omniautocomplete HTML
autocmd FileType html set omnifunc=htmlcomplete#CompleteTags
"Omniautocomplete CSS
autocmd FileType css set omnifunc=htmlcomplete#CompleteCSS
"Omniautocomplete javascript
autocmd FileType javascript set omnifunc=javascriptcomplete#CompleteJS
let jshint_save = 1
"Omniautocomplete PHP
autocmd FileType php set omnifunc=phpcomplete#CompletePHP
"Omniautocomplete python
let g:pydiction_location='/Users/andrea/.vim/bundle/pydiction/complete-dict'
"Fix Css3 syntax
augroup VimCSS3Syntax
	autocmd!
	autocmd Filetype css setlocal iskeyword+=-
augroup END
"Vim beautify
au BufWrite * :Autoformat
"Fonts in gui mode
if(has('gui_running'))
	set guifont=Roboto\ Mono
endif

"Python tabs
au BufNewFile,BufRead *.py set tabstop=4 softtabstop=4 shiftwidth=4 textwidth=79 expandtab autoindent fileformat=unix
"HTML,JS,Css tab
au BufNewFile,BufRead *.py
	\ set tabstop=2
	\ softtabstop=2
	\ shiftwidth=2


"syntastic
set statusline+=%#warningmsg#
set statusline+=%{SyntasticStatuslineFlag()}
set statusline+=%*

let g:syntastic_always_populate_loc_list = 1
let g:syntastic_auto_loc_list = 1
let g:syntastic_check_on_open = 1
let g:syntastic_check_on_wq = 0

"Virtualenv support
py << EOF
import os
import sys
if 'VIRTUAL_ENV' in os.environ:
	project_base_dir=os.environ['VIRTUAL_ENV']
	activate_this = os.path.join(project_base_dir,'bin/activate_this.py')
	execfile(activate_this,dict(__file__=activate_this))
EOF
"""""""
